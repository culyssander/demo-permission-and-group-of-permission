package com.discord.demo_app.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "USER_PERMISSION_TABLE")
@Data
public class UserPermission {
    @EmbeddedId
    private UserPermissionId userPermissionId;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
