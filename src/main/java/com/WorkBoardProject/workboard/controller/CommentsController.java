package com.WorkBoardProject.workboard.controller;

import com.WorkBoardProject.workboard.dto.Request.CreateCommentRequest;
import com.WorkBoardProject.workboard.entity.Comments;
import com.WorkBoardProject.workboard.service.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
@Data
@Tag(name = "Comments Controller")
public class CommentsController {

    private final CommentService commentService;

    @Operation(summary = "Add a comment")
    @PostMapping
    public String create(@Valid @RequestBody CreateCommentRequest commentRequest) {
        return commentService.create(commentRequest);
    }

    @Operation(summary = "Retreive comments by task Id")
    @GetMapping("/task/{taskId}")
    public List<Comments> findByTask(@PathVariable Long taskId) {
        return commentService.findByTask(taskId);
    }
}
