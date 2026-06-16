package com.WorkBoardProject.workboard.serviceimpl;

import com.WorkBoardProject.workboard.dto.Request.LoginRequest;
import com.WorkBoardProject.workboard.dto.Request.UpdateUserRequest;
import com.WorkBoardProject.workboard.dto.Response.UserResponse;
import com.WorkBoardProject.workboard.entity.Users;
import com.WorkBoardProject.workboard.repository.UserRepository;
import com.WorkBoardProject.workboard.service.UserService;
import lombok.Data;
import org.hibernate.sql.Update;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service
@Data
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserResponse update(String email, UpdateUserRequest request) {
        Users users = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));

        UserResponse userResponse = new UserResponse();
        users.setName(request.getName());
        users.setEmail(request.getEmail());
        users.setPassword(request.getPassword());

        Users savedUser = userRepository.save(users);

        UserResponse userResponse2 = new UserResponse();
        userResponse2.setName(savedUser.getName());
        userResponse2.setEmail(savedUser.getEmail());
        userResponse2.setPassword(savedUser.getPassword());
        return userResponse2;

    }

    @Override
    public String delete(String email) {
        Users users = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));
        userRepository.delete(users);
        return "Deleted successfully for : " + users.getEmail();
    }
}
