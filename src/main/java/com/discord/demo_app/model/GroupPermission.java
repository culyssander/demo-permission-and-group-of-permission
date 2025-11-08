package com.discord.demo_app.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "GROUP_PERMISSION_TABLE")
@Data
public class GroupPermission {
    @EmbeddedId
    private GroupPermissionId groudPermissionId;
}
