package com.WorkBoardProject.workboard.dto.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateProjectRequest {

    @NotBlank(message = "Project name cannot be empty")
    private String projectName;

    @NotBlank(message = "Project description cannot be empty")
    @Size(max = 200, message = "Project description cannot exceed 200 characters")
    private String projectDescription;
}
