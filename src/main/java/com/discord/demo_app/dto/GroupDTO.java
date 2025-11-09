package com.discord.demo_app.dto;

import com.discord.demo_app.model.Permission;
import lombok.Data;

import java.util.List;

@Data
public class GroupDTO {
    private Integer groupId;
    private String name;
    private String description;
    private List<Permission> permissions;
}
