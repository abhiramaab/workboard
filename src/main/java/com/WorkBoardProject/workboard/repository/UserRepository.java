package com.WorkBoardProject.workboard.repository;

import com.WorkBoardProject.workboard.entity.Users;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {

    Optional<Users> findByEmail(String email);
}
