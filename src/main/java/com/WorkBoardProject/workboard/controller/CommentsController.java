package com.WorkBoardProject.workboard.controller;

import com.WorkBoardProject.workboard.dto.Request.CreateCommentRequest;
import com.WorkBoardProject.workboard.entity.Comments;
import com.WorkBoardProject.workboard.service.CommentService;
import jakarta.validation.Valid;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
@Data
public class CommentsController {

    private final CommentService commentService;

    @PostMapping
    public String create(@Valid @RequestBody CreateCommentRequest commentRequest) {
        return commentService.create(commentRequest);
    }

    @GetMapping("/task/{taskId}")
    public List<Comments> findByTask(@PathVariable Long taskId) {
        return commentService.findByTask(taskId);
    }
}
