
package com.frnbrz.task;

import com.frnbrz.project.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository repository;
    private final ProjectRepository projectRepository;

    public Task save(TaskRequest request) {
        //var project = projectRepository.findById(1);
        //if (project.isEmpty()) {
        //   throw new RuntimeException("Project not found");
        //}
        var task = Task.builder()
                .id(request.getId())
                .title(request.getTitle())
                .description(request.getDescription())
                //      .project(project.get())
                .build();
        repository.save(task);

        return task;
    }

    public List<Task> findAll() {
        return repository.findAll();
    }
}
