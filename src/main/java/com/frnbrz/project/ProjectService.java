package com.frnbrz.project;

import com.frnbrz.task.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository repository;

    public Project save(ProjectRequest request) {
        var task1 = Task.builder()
                .id(1)
                .title("Task 1")
                .description("Description 1")
                .status("todo")
                .build();
        var task2 = Task.builder()
                .id(2)
                .title("Task 2")
                .description("Description 2")
                .status("todo")
                .build();
        var task3 = Task.builder()
                .id(3)
                .title("Task 3")
                .description("Description 3")
                .status("todo")
                .build();
        var task4 = Task.builder()
                .id(4)
                .title("Task 4")
                .description("Description 4")
                .status("todo")
                .build();
        var project = Project.builder()
                .id(request.getId())
                .title(request.getTitle())
                .description(request.getDescription())
                .tasks(List.of(task1, task2, task3, task4))
                .build();
        repository.save(project);

        return project;
    }

    public List<Project> findAll() {
        return repository.findAll();
    }

    public Project findById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found"));
    }
}
