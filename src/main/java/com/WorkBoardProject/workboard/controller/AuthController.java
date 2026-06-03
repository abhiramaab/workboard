package com.WorkBoardProject.workboard.controller;

import com.WorkBoardProject.workboard.dto.Request.LoginRequest;
import com.WorkBoardProject.workboard.dto.Request.RegisterRequest;
import com.WorkBoardProject.workboard.dto.Response.AuthResponse;
import com.WorkBoardProject.workboard.service.AuthService;
import jakarta.validation.Valid;
import lombok.Data;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@Data
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public String register(@Valid @RequestBody RegisterRequest registerRequest) {
        return authService.register(registerRequest);
    }

    @PostMapping("/login")
    public AuthResponse login(@Valid @RequestBody LoginRequest loginRequest) {
       return authService.login(loginRequest);
    }
}
