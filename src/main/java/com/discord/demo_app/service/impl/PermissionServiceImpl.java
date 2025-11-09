package com.discord.demo_app.service.impl;

import com.discord.demo_app.model.Permission;
import com.discord.demo_app.repository.PermissionRepository;
import com.discord.demo_app.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public void validatePermission(Integer userId, String permissionName) {
        Optional<Permission> permissionByUserId = permissionRepository.findByPermissionNameAndUserId(permissionName, userId);

        if (permissionByUserId.isPresent()){
            return;
        }


        Optional<Permission> groupPermissionByUserIdAndPermissionName = permissionRepository.findGroupPermissionByUserIdAndPermissionName(permissionName, userId);

        if (groupPermissionByUserIdAndPermissionName.isEmpty()) {
            throw new RuntimeException("NO PERMISSION");
        }
    }

    @Override
    public List<Permission> findPermissionByUserId(Integer userId) {
        return permissionRepository.findPermissionByUserId(userId);
    }
}
