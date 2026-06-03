package com.WorkBoardProject.workboard.controller;

import com.WorkBoardProject.workboard.dto.Request.CreateProjectRequest;
import com.WorkBoardProject.workboard.entity.Projects;
import com.WorkBoardProject.workboard.service.ProjectService;
import jakarta.validation.Valid;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
@Data
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping
    public String create(@Valid @RequestBody CreateProjectRequest createProjectRequest) {
        return projectService.create(createProjectRequest);
    }

    @GetMapping
    public List<Projects> findAll() {
        return projectService.findAll();
    }

    @GetMapping("/{id}")
    public Projects findById(@PathVariable Long id) {
        return projectService.findById(id);
    }
}
