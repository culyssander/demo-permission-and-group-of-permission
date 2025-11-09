package com.discord.demo_app.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroupPermissionId {
    private Integer groupId;
    private Integer permissionId;
}
