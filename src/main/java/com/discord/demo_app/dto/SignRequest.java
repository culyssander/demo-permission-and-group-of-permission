package com.discord.demo_app.dto;

import lombok.Data;

@Data
public class SignRequest {
    private String email;
    private String password;
}
