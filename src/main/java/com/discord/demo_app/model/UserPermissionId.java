package com.discord.demo_app.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class UserPermissionId {
    private Long userId;
    private Long permissionId;
}
