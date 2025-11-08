package com.discord.demo_app.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "USER_GROUP_PERMISSION_TABLE")
@Data
public class UserGroupPermission{
    @EmbeddedId
    private UserGroupPermissionId userGroupPermissionId;
}
