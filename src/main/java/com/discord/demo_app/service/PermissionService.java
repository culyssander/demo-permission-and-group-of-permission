package com.discord.demo_app.service;

import com.discord.demo_app.model.Permission;

import java.util.List;
import java.util.Optional;

public interface PermissionService {

    void validatePermission(Integer userId, String permissionName);

    List<Permission> findPermissionByUserId(Integer userId);
}
