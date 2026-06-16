package com.WorkBoardProject.workboard.service;

import com.WorkBoardProject.workboard.dto.Request.CreateProjectRequest;
import com.WorkBoardProject.workboard.entity.Projects;

import java.util.List;

public interface ProjectService {

    String create(CreateProjectRequest createProjectRequest);
    Projects findById(Long id);
    List<Projects> findAll();

    String update(Long id, CreateProjectRequest createProjectRequest);
    String delete(Long id);
}
