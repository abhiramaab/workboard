package com.WorkBoardProject.workboard.controller;

import com.WorkBoardProject.workboard.dto.Request.LoginRequest;
import com.WorkBoardProject.workboard.dto.Request.RegisterRequest;
import com.WorkBoardProject.workboard.dto.Response.AuthResponse;
import com.WorkBoardProject.workboard.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.Data;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@Data
@Tag(name = "Auth Controller")
public class AuthController {

    private final AuthService authService;

    @Operation(summary = "Register a user")
    @PostMapping("/register")
    public String register(@Valid @RequestBody RegisterRequest registerRequest) {
        return authService.register(registerRequest);
    }

    @Operation(summary = "Login as user")
    @PostMapping("/login")
    public AuthResponse login(@Valid @RequestBody LoginRequest loginRequest) {
       return authService.login(loginRequest);
    }
}
