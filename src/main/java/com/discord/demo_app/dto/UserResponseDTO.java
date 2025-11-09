package com.discord.demo_app.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class UserResponseDTO {
    private Integer userId;
    private String name;
    private boolean status;
    private String email;
    private String role;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
