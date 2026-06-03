package com.WorkBoardProject.workboard.repository;

import com.WorkBoardProject.workboard.entity.Projects;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Projects, Long> {
}
