package com.WorkBoardProject.workboard.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "projects")
@Data
public class Projects {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String projectName;

    private String projectDescription;

    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "created_by")
    @JsonBackReference
    private Users createdBy;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Tasks> tasks;
}
