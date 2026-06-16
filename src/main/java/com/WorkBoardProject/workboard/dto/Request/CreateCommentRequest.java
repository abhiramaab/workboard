package com.WorkBoardProject.workboard.dto.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateCommentRequest {

    @NotBlank(message = "Comment cannot be empty")
    private String message;

    @NotNull(message = "TaskId cannot be empty")
    private Long taskId;
}
