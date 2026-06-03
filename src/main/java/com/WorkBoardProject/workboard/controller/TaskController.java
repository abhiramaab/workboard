package com.WorkBoardProject.workboard.controller;

import com.WorkBoardProject.workboard.dto.Request.CreateTaskRequest;
import com.WorkBoardProject.workboard.dto.Request.UpdateTaskStatusRequest;
import com.WorkBoardProject.workboard.entity.Tasks;
import com.WorkBoardProject.workboard.enums.Priority;
import com.WorkBoardProject.workboard.enums.Status;
import com.WorkBoardProject.workboard.service.TaskService;
import jakarta.validation.Valid;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@Data
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    public String create(@Valid @RequestBody CreateTaskRequest createTaskRequest) {
        return taskService.create(createTaskRequest);
    }

    @GetMapping
    public List<Tasks> findAll() {
        return taskService.findAll();
    }

    @GetMapping("/{id}")
    public Tasks findById(@PathVariable Long id) {
        return taskService.findById(id);
    }

    @PatchMapping("/{id}")
    public String update(@PathVariable Long id,@Valid @RequestBody CreateTaskRequest createTaskRequest) {
        return taskService.update(id, createTaskRequest);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return taskService.delete(id);
    }

    @GetMapping("/status/{status}")
    public List<Tasks> findByStatus(@PathVariable String status) {
        return taskService.findByStatus(status);
    }

    @GetMapping("/priority/{priority}")
    public List<Tasks> findByPriority(@PathVariable Priority priority) {
        return taskService.findByPriority(priority);
    }

    @GetMapping("/user/{userId}")
    public List<Tasks> findByUser(@PathVariable Long userId) {
        return taskService.findByUser(userId);
    }

    @GetMapping("/project/{projectId}")
    public List<Tasks> findByProject(@PathVariable Long projectId) {
        return taskService.findByProject(projectId);
    }

    @PatchMapping("/{id}/status")
    public String updateStatus(@PathVariable Long id,@Valid @RequestBody UpdateTaskStatusRequest updateTaskStatusRequest) {
        return taskService.updateStatus(id,updateTaskStatusRequest.getStatus());
    }
}
