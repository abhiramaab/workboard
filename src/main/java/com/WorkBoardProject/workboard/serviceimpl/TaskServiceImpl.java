package com.WorkBoardProject.workboard.serviceimpl;

import com.WorkBoardProject.workboard.dto.Request.CreateTaskRequest;
import com.WorkBoardProject.workboard.entity.Projects;
import com.WorkBoardProject.workboard.entity.Tasks;
import com.WorkBoardProject.workboard.entity.Users;
import com.WorkBoardProject.workboard.enums.Priority;
import com.WorkBoardProject.workboard.enums.Status;
import com.WorkBoardProject.workboard.repository.ProjectRepository;
import com.WorkBoardProject.workboard.repository.TaskRepository;
import com.WorkBoardProject.workboard.repository.UserRepository;
import com.WorkBoardProject.workboard.service.TaskService;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;

    @Override
    public String create(CreateTaskRequest createTaskRequest) {
        Projects projects = projectRepository.findById(createTaskRequest.getProjectId()).orElseThrow(() -> new RuntimeException("Project Not Found"));

        Users user = userRepository.findById(createTaskRequest.getAssignedUserId()).orElseThrow(() -> new RuntimeException("User not found"));

        Tasks task = new Tasks();

        task.setTitle(createTaskRequest.getTitle());
        task.setDescription(createTaskRequest.getDescription());
        task.setPriority(createTaskRequest.getPriority());
        task.setDueDate(createTaskRequest.getDueDate());
        task.setStatus(Status.TODO);

        task.setProject(projects);
        task.setAssignedUser(user);

        taskRepository.save(task);
        return "Task created : " + task.getTitle();
    }

    @Override
    public Tasks findById(Long id) {
        return taskRepository.findById(id).get();
    }

    @Override
    public List<Tasks> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public String update(Long id, CreateTaskRequest createTaskRequest) {
        Tasks ExistingTask = taskRepository.findById(id).get();

        if (createTaskRequest.getTitle() != null) {
            ExistingTask.setTitle(createTaskRequest.getTitle());
        }

        if (createTaskRequest.getDescription() != null) {
            ExistingTask.setDescription(createTaskRequest.getDescription());
        }

        if (createTaskRequest.getPriority() != null) {
            ExistingTask.setPriority(createTaskRequest.getPriority());
        }

        if (createTaskRequest.getDueDate() != null) {
            ExistingTask.setDueDate(createTaskRequest.getDueDate());
        }

        if (createTaskRequest.getProjectId() != null) {
            Projects projects = projectRepository.findById(createTaskRequest.getProjectId()).orElseThrow(() -> new RuntimeException("Project Not Found"));
            ExistingTask.setProject(projects);
        }

        if (createTaskRequest.getAssignedUserId() != null) {
            Users users = userRepository.findById(createTaskRequest.getAssignedUserId()).orElseThrow(() -> new RuntimeException("User not found"));
            ExistingTask.setAssignedUser(users);
        }
        taskRepository.save(ExistingTask);
        return "Tasks updated : " + ExistingTask.getTitle();
    }

    @Override
    public String delete(Long id) {
        taskRepository.deleteById(id);
        return "Task deleted : " + id;
    }

    @Override
    public List<Tasks> findByStatus(String status) {
        Status taskStatus = Status.valueOf(status.toUpperCase());

        return taskRepository.findByStatus(taskStatus);
    }

    @Override
    public List<Tasks> findByPriority(Priority priority) {
        return taskRepository.findByPriority(priority);
    }

    @Override
    public List<Tasks> findByUser(Long userId) {
        return taskRepository.findByAssignedUserId(userId);
    }

    @Override
    public List<Tasks> findByProject(Long projectId) {
        return taskRepository.findByProjectId(projectId);
    }

    @Override
    public String updateStatus(Long id, Status status) {
        Tasks task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));

        task.setStatus(status);

        taskRepository.save(task);
        return "Tasks status updated to : " + task.getStatus();
    }
}
