package com.frnbrz.project;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository repository;

    public void create(ProjectRequest request) {
        var project = Project.builder()
                .id(request.getId())
                .title(request.getTitle())
                .description(request.getDescription())
                .build();
        repository.save(project);
    }

    public List<Project> findAll() {
        return repository.findAll();
    }

    public void update(Integer id, ProjectRequest request) {
        var project = Project.builder()
                .id(id)
                .title(request.getTitle())
                .description(request.getDescription())
                .build();
        repository.save(project);
    }

    public Project findById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found"));
    }
}
