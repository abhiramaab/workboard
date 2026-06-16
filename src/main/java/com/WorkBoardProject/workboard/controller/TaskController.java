package com.WorkBoardProject.workboard.controller;

import com.WorkBoardProject.workboard.dto.Request.CreateTaskRequest;
import com.WorkBoardProject.workboard.dto.Request.UpdateTaskStatusRequest;
import com.WorkBoardProject.workboard.entity.Tasks;
import com.WorkBoardProject.workboard.enums.Priority;
import com.WorkBoardProject.workboard.enums.Status;
import com.WorkBoardProject.workboard.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@Data
@Tag(name = "Task Controller")
public class TaskController {

    private final TaskService taskService;

    @Operation(summary = "Create a Task")
    @PostMapping
    public String create(@Valid @RequestBody CreateTaskRequest createTaskRequest) {
        return taskService.create(createTaskRequest);
    }

    @Operation(summary = "Retrieve all tasks")
    @GetMapping
    public List<Tasks> findAll() {
        return taskService.findAll();
    }

    @Operation(summary = "Retrieve a task by Id")
    @GetMapping("/{id}")
    public Tasks findById(@PathVariable Long id) {
        return taskService.findById(id);
    }

    @Operation(summary = "Update a task partially")
    @PatchMapping("/{id}")
    public String update(@PathVariable Long id,@Valid @RequestBody CreateTaskRequest createTaskRequest) {
        return taskService.update(id, createTaskRequest);
    }

    @Operation(summary = "Delete a task")
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return taskService.delete(id);
    }

    @Operation(summary = "Retrieve a status")
    @GetMapping("/status/{status}")
    public List<Tasks> findByStatus(@PathVariable String status) {
        return taskService.findByStatus(status);
    }

    @Operation(summary = "Check priority")
    @GetMapping("/priority/{priority}")
    public List<Tasks> findByPriority(@PathVariable Priority priority) {
        return taskService.findByPriority(priority);
    }

    @Operation(summary = "Retrieve task by userId")
    @GetMapping("/user/{userId}")
    public List<Tasks> findByUser(@PathVariable Long userId) {
        return taskService.findByUser(userId);
    }

    @Operation(summary = "Retrieve task by projectId")
    @GetMapping("/project/{projectId}")
    public List<Tasks> findByProject(@PathVariable Long projectId) {
        return taskService.findByProject(projectId);
    }

    @Operation(summary = "Update status")
    @PatchMapping("/{id}/status")
    public String updateStatus(@PathVariable Long id,@Valid @RequestBody UpdateTaskStatusRequest updateTaskStatusRequest) {
        return taskService.updateStatus(id,updateTaskStatusRequest.getStatus());
    }
}
