package com.discord.demo_app.service.impl;

import com.discord.demo_app.model.GroupPermission;
import com.discord.demo_app.model.GroupPermissionId;
import com.discord.demo_app.repository.GroupPermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupPermissionServiceImp {

    @Autowired
    private GroupPermissionRepository groupPermissionRepository;

    public GroupPermission save(Integer groupId, Integer permissionId) {
        GroupPermissionId groupPermissionId = new GroupPermissionId(groupId, permissionId);

        return groupPermissionRepository.save(GroupPermission
                .builder()
                .groudPermissionId(groupPermissionId)
                .build());
    }
}
