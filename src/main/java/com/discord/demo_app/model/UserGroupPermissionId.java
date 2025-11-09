package com.discord.demo_app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class UserGroupPermissionId {
    private Integer userId;
    @Column(name = "group_id")
    private Integer groudId;
}
