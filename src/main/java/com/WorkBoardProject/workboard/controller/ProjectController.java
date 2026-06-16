package com.WorkBoardProject.workboard.controller;

import com.WorkBoardProject.workboard.dto.Request.CreateProjectRequest;
import com.WorkBoardProject.workboard.entity.Projects;
import com.WorkBoardProject.workboard.service.ProjectService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
@Data
@Tag(name = "Project Controller")
public class ProjectController {

    private final ProjectService projectService;

    @Operation(summary = "Create a project")
    @PostMapping
    public String create(@Valid @RequestBody CreateProjectRequest createProjectRequest) {
        return projectService.create(createProjectRequest);
    }

    @Operation(summary = "Retreive all projects")
    @GetMapping
    public List<Projects> findAll() {
        return projectService.findAll();
    }

    @Operation(summary = "Retrieve project by Id")
    @GetMapping("/{id}")
    public Projects findById(@PathVariable Long id) {
        return projectService.findById(id);
    }
}
