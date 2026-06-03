package com.WorkBoardProject.workboard.repository;

import com.WorkBoardProject.workboard.entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comments, Long> {

    List<Comments> findByTask(Long taskId);
}
