package com.WorkBoardProject.workboard.dto.Request;

import com.WorkBoardProject.workboard.enums.Priority;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateTaskRequest {

    @NotBlank
    private String title;

    @NotBlank(message = "Comment cannot be empty")
    @Size(max = 50, message = "Descripion cannot exceed 50 characters")
    private String description;

    @NotBlank(message = "Priority cannot be blank")
    private Priority priority;

    @Future
    private LocalDateTime dueDate;

    @NotNull(message = "ProjectId cannot be empty")
    private Long projectId;

    @NotNull(message = "AssignedUserId cannot be empty")
    private Long assignedUserId;
}
