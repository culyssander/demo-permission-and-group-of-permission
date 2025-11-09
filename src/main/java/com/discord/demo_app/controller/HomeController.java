package com.discord.demo_app.controller;

import com.discord.demo_app.dto.SignRequest;
import com.discord.demo_app.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class HomeController {

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping
    public String welcome() {
        System.out.println(new BCryptPasswordEncoder().encode("1234"));
        return "It's Working!.";
    }

    @PostMapping(path = "/api/v1/sign", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> sign(@Validated @RequestBody SignRequest signRequest) {
        try {
//            authenticationProvider.authenticate(new UsernamePasswordAuthenticationToken(signRequest.getPassword(), signRequest.getPassword()));
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signRequest.getEmail(), signRequest.getPassword()));
        } catch (Exception ex) {
            throw new RuntimeException("EMAIL OR PASSWORD INVALID");
        }

        // save last login

        String token = String.format("{\"token\": \"%s\"}", jwtUtil.generateToken(signRequest.getEmail()));
        return ResponseEntity.ok(token);
    }
}
