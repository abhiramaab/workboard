package com.WorkBoardProject.workboard.service;

import com.WorkBoardProject.workboard.dto.Request.LoginRequest;
import com.WorkBoardProject.workboard.dto.Request.UpdateUserRequest;
import com.WorkBoardProject.workboard.dto.Response.UserResponse;
import org.springframework.security.core.userdetails.User;

public interface UserService {

    UserResponse update(String email, UpdateUserRequest request);
    String delete(String email);
}
