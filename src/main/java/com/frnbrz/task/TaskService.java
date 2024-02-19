
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
        var project = projectRepository.findById(request.getProjectId());
        if (project.isEmpty()) {
           throw new RuntimeException("Project not found");
        }
        var task = Task.builder()
                .id(request.getId())
                .title(request.getTitle())
                .description(request.getDescription())
                .project(project.get())
                .status("todo")
                .build();
        repository.save(task);

        return task;
    }

    public List<Task> findAll() {
        return repository.findAll();
    }

    public Task update(Integer id, TaskRequest request) {
        var task = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        repository.save(task);
        return task;
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
