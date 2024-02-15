package com.frnbrz.task;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository repository;

    public void save(TaskRequest request) {
        var book = Task.builder()
                .id(request.getId())
                .title(request.getTitle())
                .description(request.getDescription())
                .build();
        repository.save(book);
    }

    public List<Task> findAll() {
        return repository.findAll();
    }

    public void update(Integer id, TaskRequest request) {
        var task = Task.builder()
                .id(id)
                .title(request.getTitle())
                .description(request.getDescription())
                .build();
        repository.save(task);
    }
}
