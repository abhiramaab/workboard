package com.WorkBoardProject.workboard.service;

import com.WorkBoardProject.workboard.dto.Response.AuthResponse;
import com.WorkBoardProject.workboard.dto.Request.LoginRequest;
import com.WorkBoardProject.workboard.dto.Request.RegisterRequest;

public interface AuthService {

    String register(RegisterRequest registerRequest);
    AuthResponse login(LoginRequest loginRequest);
}
