package com.WorkBoardProject.workboard.service;

import com.WorkBoardProject.workboard.dto.Request.CreateCommentRequest;
import com.WorkBoardProject.workboard.entity.Comments;

import java.util.List;

public interface CommentService {

    String create(CreateCommentRequest createCommentRequest);
    List<Comments> findByTask(Long taskId);
}
