package com.discord.demo_app.service;

import com.discord.demo_app.dto.UserAdminRequestDto;
import com.discord.demo_app.dto.UserDefaultRequestDTO;
import com.discord.demo_app.dto.UserResponseDTO;
import com.discord.demo_app.model.Permission;
import com.discord.demo_app.model.UserPermission;
import com.discord.demo_app.model.UserPermissionId;

import java.util.List;
import java.util.Optional;

public interface UserService {

    UserResponseDTO createDefaultUser(UserDefaultRequestDTO userDefaultRequestDTO);
    UserResponseDTO createAdminUser(UserAdminRequestDto userAdminRequestDto);
    UserResponseDTO updateUserPassword(String oldPassword, String newPassword);
    boolean disableUser(Long userId);
    List<UserResponseDTO> findAll();
    Optional<UserResponseDTO> findById(Long userId);

    UserPermission addPermissionToUser(UserPermissionId userPermissionIds);

    List<Permission> findAllPermissionByUserId(Integer userId);
}
