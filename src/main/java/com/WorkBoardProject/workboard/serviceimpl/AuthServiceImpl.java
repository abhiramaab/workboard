package com.WorkBoardProject.workboard.serviceimpl;

import com.WorkBoardProject.workboard.dto.Request.LoginRequest;
import com.WorkBoardProject.workboard.dto.Request.RegisterRequest;
import com.WorkBoardProject.workboard.dto.Response.AuthResponse;
import com.WorkBoardProject.workboard.entity.Users;
import com.WorkBoardProject.workboard.enums.Role;
import com.WorkBoardProject.workboard.repository.UserRepository;
import com.WorkBoardProject.workboard.security.JwtUtil;
import com.WorkBoardProject.workboard.service.AuthService;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Data
public class AuthServiceImpl implements AuthService {

    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public String register(RegisterRequest registerRequest) {
        if (userRepository.findByEmail(registerRequest.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }

        Users users = new Users();

        users.setName(registerRequest.getName());
        users.setEmail(registerRequest.getEmail());

        users.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        users.setRole(Role.EMPLOYEE);

        userRepository.save(users);
        return "User registered successfully";
    }

    @Override
    public AuthResponse login(LoginRequest loginRequest) {
        Users users = userRepository.findByEmail(loginRequest.getEmail()).orElseThrow(() -> new RuntimeException("Invalid email"));

        boolean passwordMatches = passwordEncoder.matches(loginRequest.getPassword(), users.getPassword());
        if (!passwordMatches) {
            throw new RuntimeException("Invalid password");
        }
        String token = jwtUtil.generateToken(users.getEmail());

        return new AuthResponse(token, users.getEmail(), users.getRole().name(), "Login successful");
    }
}
