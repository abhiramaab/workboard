package com.WorkBoardProject.workboard.entity;

import com.WorkBoardProject.workboard.enums.Role;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "users")
@Data
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long Id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "createdBy")
    private List<Projects> projects;

    @OneToMany(mappedBy = "assignedUser")
    private List<Tasks> assignedTasks;

}
