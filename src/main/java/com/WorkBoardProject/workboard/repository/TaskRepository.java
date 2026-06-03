package com.WorkBoardProject.workboard.repository;

import com.WorkBoardProject.workboard.entity.Tasks;
import com.WorkBoardProject.workboard.enums.Priority;
import com.WorkBoardProject.workboard.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Tasks, Long> {

    List<Tasks> findByStatus(Status status);
    List<Tasks> findByPriority(Priority priority);
    List<Tasks> findByAssignedUserId(Long userId);
    List<Tasks> findByProjectId(Long projectId);
}
