package com.discord.demo_app.controller;

import com.discord.demo_app.dto.UserDefaultRequestDTO;
import com.discord.demo_app.dto.UserResponseDTO;
import com.discord.demo_app.model.Permission;
import com.discord.demo_app.model.UserPermission;
import com.discord.demo_app.model.UserPermissionId;
import com.discord.demo_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("default")
    public UserResponseDTO createDefaultUser(@RequestBody UserDefaultRequestDTO userDefaultRequestDTO) {
        return userService.createDefaultUser(userDefaultRequestDTO);
    }

    @PostMapping("add-group-of-permission")
    public boolean addGroupOfPermissionToUser(@PathVariable Integer userId, @PathVariable Integer groupId) {
        // not implements
        return false;
    }

    @PostMapping("add-permission")
    public UserPermission addPermissionToUser(@RequestBody UserPermissionId userPermissionIds) {
        return userService.addPermissionToUser(userPermissionIds);
    }

    @GetMapping("{userId}/permissions")
    public List<Permission> findAllPermissionByUserId(@PathVariable Integer userId) {
        return userService.findAllPermissionByUserId(userId);
    }
}
