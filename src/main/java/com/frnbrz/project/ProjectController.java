package com.frnbrz.project;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService service;

    @PostMapping
    public ResponseEntity<Project> save(
            @RequestBody ProjectRequest request
    ) {
        var newProject = service.save(request);
        return new ResponseEntity<>(newProject, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Project>> findAllBooks() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> findById(
            @PathVariable Integer id
    ) {
        return ResponseEntity.ok(service.findById(id));
    }
}
