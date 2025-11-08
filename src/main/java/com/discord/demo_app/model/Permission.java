package com.discord.demo_app.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "PERMISSION_TABLE")
@Data
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long permissionId;
    private String name;
    private String description;
}
