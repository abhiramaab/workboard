package com.WorkBoardProject.workboard.dto.Request;

import com.WorkBoardProject.workboard.enums.Status;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateTaskStatusRequest {


    private Status status;
}
