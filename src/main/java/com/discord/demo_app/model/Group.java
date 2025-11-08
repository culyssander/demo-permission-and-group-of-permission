package com.discord.demo_app.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "GROUP_TABLE")
@Data
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long groupId;
    private String name;
    private String description;

}
