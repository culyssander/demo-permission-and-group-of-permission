package com.discord.demo_app.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "GROUP_TABLE")
@Data
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id")
    private Integer groupId;
    private String name;
    private String description;

}
