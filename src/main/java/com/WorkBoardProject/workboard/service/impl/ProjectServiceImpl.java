package com.WorkBoardProject.workboard.service.impl;

import com.WorkBoardProject.workboard.dto.Request.CreateProjectRequest;
import com.WorkBoardProject.workboard.entity.Projects;
import com.WorkBoardProject.workboard.repository.ProjectRepository;
import com.WorkBoardProject.workboard.service.ProjectService;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Data
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    @Override
    public String create(CreateProjectRequest createProjectRequest) {
        Projects project = new Projects();

        project.setProjectName(createProjectRequest.getProjectName());
        project.setProjectDescription(createProjectRequest.getProjectDescription());
        project.setCreatedAt(LocalDateTime.now());

        projectRepository.save(project);
        return "Project Created : " + project.getProjectName();
    }

    @Override
    public Projects findById(Long id) {
        return projectRepository.findById(id).get();
    }

    @Override
    public List<Projects> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public String update(Long id, CreateProjectRequest createProjectRequest) {
        Projects ExistingProject = projectRepository.findById(id).get();

        if (createProjectRequest.getProjectName() != null) {
            ExistingProject.setProjectName(createProjectRequest.getProjectName());
        }

        if (createProjectRequest.getProjectDescription() != null) {
            ExistingProject.setProjectDescription(createProjectRequest.getProjectDescription());
        }

        projectRepository.save(ExistingProject);
        return "Project updated : " + ExistingProject.getProjectName();
    }

    @Override
    public String delete(Long id) {
        projectRepository.deleteById(id);
        return "Project Deleted Successfully : " + id;
    }
}
