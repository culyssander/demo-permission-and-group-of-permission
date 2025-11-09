package com.discord.demo_app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "GROUP_PERMISSION_TABLE")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GroupPermission {
    @EmbeddedId
    private GroupPermissionId groudPermissionId;
}
