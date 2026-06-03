package com.WorkBoardProject.workboard.security;

import com.WorkBoardProject.workboard.entity.Users;
import com.WorkBoardProject.workboard.exception.NotFoundException;
import com.WorkBoardProject.workboard.repository.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Data;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
@Data
public class JwtFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String header = request.getHeader("Authorization");
        if (header != null && header.startsWith("Bearer ")) {
            String token = header.substring(7);

            String email = jwtUtil.extractEmail(token);
            Users users = userRepository.findByEmail(email).orElseThrow(() -> new NotFoundException("User not found"));

            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(token, null, List.of(new SimpleGrantedAuthority("ROLE_" + users.getRole().name())));

            SecurityContextHolder.getContext().setAuthentication(auth);
        }
        filterChain.doFilter(request, response);
    }
}
