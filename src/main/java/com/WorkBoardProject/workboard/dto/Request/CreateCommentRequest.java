package com.WorkBoardProject.workboard.dto.Request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateCommentRequest {

    @NotBlank
    private String message;

    private Long taskId;
}
