package com.frnbrz.task;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService service;

    @PatchMapping("/{id}")
    public ResponseEntity<?> update(
            @PathVariable Integer id,
            @RequestBody TaskRequest request
    ) {
        service.update(id, request);
        return ResponseEntity.accepted().build();
    }

    @PostMapping
    public ResponseEntity<?> save(
            @RequestBody TaskRequest request
    ) {
        service.save(request);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    public ResponseEntity<List<Task>> findAllBooks() {
        return ResponseEntity.ok(service.findAll());
    }
}
