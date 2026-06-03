package com.WorkBoardProject.workboard.service.impl;

import com.WorkBoardProject.workboard.dto.Request.CreateCommentRequest;
import com.WorkBoardProject.workboard.entity.Comments;
import com.WorkBoardProject.workboard.entity.Tasks;
import com.WorkBoardProject.workboard.repository.CommentRepository;
import com.WorkBoardProject.workboard.repository.TaskRepository;
import com.WorkBoardProject.workboard.service.CommentService;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Data
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final TaskRepository taskRepository;

    @Override
    public String create(CreateCommentRequest createCommentRequest) {
        Tasks tasks = taskRepository.findById(createCommentRequest.getTaskId()).orElseThrow(() -> new RuntimeException("Task not found"));

        Comments comments = new Comments();

        comments.setMessage(createCommentRequest.getMessage());
        comments.setCreatedAt(LocalDateTime.now());
        comments.setTask(tasks);

        commentRepository.save(comments);
        return "Comment added successfully at : " + comments.getCreatedAt();
    }

    @Override
    public List<Comments> findByTask(Long taskId) {
        return commentRepository.findByTask(taskId);
    }
}
