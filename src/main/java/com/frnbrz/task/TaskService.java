package com.frnbrz.task;

import com.frnbrz.project.Project;
import com.frnbrz.project.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository repository;
    private final ProjectService service;


    public Task create(TaskRequest request) {
        Project project = service.findById(request.getProjectId());
        Task task = Task.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .project(project)
                .build();
        return repository.save(task);
    }

    public List<Task> findAll() {
        return repository.findAll();
    }
}
