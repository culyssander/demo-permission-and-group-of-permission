package com.discord.demo_app.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class GroupPermissionId {
    private Long groupId;
    private Long permissionId;
}
