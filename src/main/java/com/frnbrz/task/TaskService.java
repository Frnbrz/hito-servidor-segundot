package com.frnbrz.task;

import com.frnbrz.project.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository repository;
    private final ProjectService service;
    private final TaskMapper mapper;


    public TaskDTO save(TaskDTO saveDTO) {
        Task task = mapper.taskDtoToTask(saveDTO);

        repository.save(task);
        return mapper.taskToLlamadaDto(task);
    }

    public List<Task> findAll() {
        return repository.findAll();
    }

    public void update(Integer id, TaskRequest request) {
        var project = service.findById(request.getProjectId());
        System.out.println(project);
        var task = Task.builder()
                .id(id)
                .project(project)
                .title(request.getTitle())
                .description(request.getDescription())
                .build();
        repository.save(task);
    }
}
