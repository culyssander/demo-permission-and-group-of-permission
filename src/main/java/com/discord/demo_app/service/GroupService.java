package com.discord.demo_app.service;

import com.discord.demo_app.dto.GroupDTO;
import com.discord.demo_app.model.Group;

import java.util.List;
import java.util.Optional;

public interface GroupService {

    Group save(Group group);
    List<Group> findAll();
    Optional<Group> findByGroupId(Integer groupId);
    List<GroupDTO> findAllWithPermission();
    List<GroupDTO> findByGroupIdWithPermission();
}
