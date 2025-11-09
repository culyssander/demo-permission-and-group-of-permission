package com.discord.demo_app.service.impl;

import com.discord.demo_app.dto.GroupDTO;
import com.discord.demo_app.model.Group;
import com.discord.demo_app.repository.GroupRepository;
import com.discord.demo_app.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupRepository groupRepository;

    @Override
    public Group save(Group group) {
        return groupRepository.save(group);
    }

    @Override
    public List<Group> findAll() {
        return groupRepository.findAll();
    }

    @Override
    public Optional<Group> findByGroupId(Integer groupId) {
        return groupRepository.findById(groupId);
    }

    @Override
    public List<GroupDTO> findAllWithPermission() {
        return List.of();
    }

    @Override
    public List<GroupDTO> findByGroupIdWithPermission() {
        return List.of();
    }
}
