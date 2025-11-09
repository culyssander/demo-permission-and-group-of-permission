package com.discord.demo_app.service.impl;

import com.discord.demo_app.dto.UserAdminRequestDto;
import com.discord.demo_app.dto.UserDefaultRequestDTO;
import com.discord.demo_app.dto.UserResponseDTO;
import com.discord.demo_app.model.Permission;
import com.discord.demo_app.model.User;
import com.discord.demo_app.model.UserPermission;
import com.discord.demo_app.model.UserPermissionId;
import com.discord.demo_app.repository.UserPermissionRepository;
import com.discord.demo_app.repository.UserRepository;
import com.discord.demo_app.service.PermissionService;
import com.discord.demo_app.service.UserService;
import com.discord.demo_app.util.JWTUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private UserPermissionRepository userPermissionRepository;

    @Autowired
    private JWTUtil jwtUtil;

    private final String USER_DEFAULT = "DEFAULT";
    private final String USER_ADMIN = "ADMIN";
    private final String PERMISSION_CREATE_DEFAULT_USER = "CREATE-DEFAULT-USER";
    private final String PERMISSION_CREATE_ADMIN_USER = "CREATE-ADMIN-USER";

    @Override
    public UserResponseDTO createDefaultUser(UserDefaultRequestDTO userDefaultRequestDTO) {
        permissionService.validatePermission(userLogged().getUserId(), PERMISSION_CREATE_DEFAULT_USER);

        if(userRepository.existsByEmail(userDefaultRequestDTO.getEmail()))
            throw new RuntimeException("Email already exists");

        User user = User.builder()
                .name(userDefaultRequestDTO.getName())
                .email(userDefaultRequestDTO.getEmail())
                .password(encodePassword(userDefaultRequestDTO.getPassword()))
                .role(USER_DEFAULT)
                .status(true)
                .createdAt(LocalDateTime.now())
                .modifiedAt(LocalDateTime.now())
                .build();

        user = userRepository.save(user);

        return mappingUser(user);
    }

    private String encodePassword(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }

    @Override
    public UserResponseDTO createAdminUser(UserAdminRequestDto userAdminRequestDto) {
        return null;
    }

    @Override
    public UserResponseDTO updateUserPassword(String oldPassword, String newPassword) {
        return null;
    }

    @Override
    public boolean disableUser(Long userId) {
        return false;
    }

    @Override
    public List<UserResponseDTO> findAll() {
        return List.of();
    }

    @Override
    public Optional<UserResponseDTO> findById(Long userId) {
        return Optional.empty();
    }

    @Override
    public UserPermission addPermissionToUser(UserPermissionId userPermissionIds) {
        return userPermissionRepository.save(UserPermission.builder().build());
    }

    @Override
    public List<Permission> findAllPermissionByUserId(Integer userId) {
        return permissionService.findPermissionByUserId(userId);
    }

    private void validateEmail(String email) {
        userRepository.findByEmail(email).orElseThrow();
    }

    private User getUser(Integer userId) {
        return userRepository.findById(userId).orElseThrow();
    }

    private User getUser(String email) {
        return userRepository.findByEmail(email).orElseThrow();
    }

    private UserResponseDTO mappingUser(User user) {
        return UserResponseDTO.builder()
                .userId(user.getUserId())
                .name(user.getName())
                .email(user.getEmail())
                .role(user.getRole())
                .status(user.isStatus())
                .createdAt(user.getCreatedAt())
                .modifiedAt(user.getModifiedAt())
                .build();
    }

    private User userLogged() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        String token = request.getHeader("Authorization").split(" ")[1];
        String email = jwtUtil.extractUsername(token);
        return getUser(email);
    }
}
