package com.WorkBoardProject.workboard.controller;

import com.WorkBoardProject.workboard.dto.Request.LoginRequest;
import com.WorkBoardProject.workboard.dto.Request.UpdateUserRequest;
import com.WorkBoardProject.workboard.dto.Response.UserResponse;
import com.WorkBoardProject.workboard.entity.Users;
import com.WorkBoardProject.workboard.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@Data
@Tag(name = "User Controller", description = "Delete, Update user details")
public class UserController {

    private final UserService userService;

    @Operation(summary = "Update user details")
    @PatchMapping("/{email}")
    public UserResponse update(@PathVariable String email, @RequestBody UpdateUserRequest request) {
        return userService.update(email, request);
    }

    @Operation(summary = "Delete a user")
    @DeleteMapping("/{email}")
    public String delete(@PathVariable String email) {
        return userService.delete(email);
    }
}
