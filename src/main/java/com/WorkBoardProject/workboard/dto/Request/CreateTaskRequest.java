package com.WorkBoardProject.workboard.dto.Request;

import com.WorkBoardProject.workboard.enums.Priority;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateTaskRequest {

    @NotBlank
    private String title;

    @NotBlank
    private String description;

    private Priority priority;

    @Future
    private LocalDateTime dueDate;

    private Long projectId;

    private Long assignedUserId;
}
