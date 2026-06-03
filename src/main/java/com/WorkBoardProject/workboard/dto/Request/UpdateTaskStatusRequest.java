package com.WorkBoardProject.workboard.dto.Request;

import com.WorkBoardProject.workboard.enums.Status;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateTaskStatusRequest {

    @NotNull
    private Status status;
}
