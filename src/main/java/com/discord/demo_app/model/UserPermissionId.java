package com.discord.demo_app.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class UserPermissionId {
    private Integer userId;
    private Integer permissionId;
}
