package com.WorkBoardProject.workboard.entity;

import com.WorkBoardProject.workboard.enums.Priority;
import com.WorkBoardProject.workboard.enums.Status;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tasks")
@Data
public class Tasks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    private LocalDateTime dueDate;

    @ManyToOne
    @JoinColumn(name = "project_id")
    @JsonBackReference
    private Projects project;

    @ManyToOne
    @JoinColumn(name = "assigned_user_id")
    @JsonBackReference
    private Users assignedUser;

    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
    private List<Comments> comments;
}
