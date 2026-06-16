package com.WorkBoardProject.workboard.service;

import com.WorkBoardProject.workboard.dto.Request.CreateTaskRequest;
import com.WorkBoardProject.workboard.entity.Tasks;
import com.WorkBoardProject.workboard.enums.Priority;
import com.WorkBoardProject.workboard.enums.Status;

import java.util.List;

public interface TaskService {

    String create(CreateTaskRequest createTaskRequest);
    Tasks findById(Long id);
    List<Tasks> findAll();
    String update(Long id, CreateTaskRequest createTaskRequest);
    String delete(Long id);
    List<Tasks> findByStatus(String status);
    List<Tasks> findByPriority(Priority priority);
    List<Tasks> findByUser(Long userId);
    List<Tasks> findByProject(Long projectId);
    String updateStatus(Long id, Status status);
}
