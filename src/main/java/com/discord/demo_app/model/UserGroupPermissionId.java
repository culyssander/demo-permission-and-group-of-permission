package com.discord.demo_app.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class UserGroupPermissionId {
    private Long userId;
    private Long groudPermissionId;
}
