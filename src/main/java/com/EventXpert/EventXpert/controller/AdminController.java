package com.EventXpert.EventXpert.controller;

import com.EventXpert.EventXpert.entity.Taskentity;
import com.EventXpert.EventXpert.entity.Taskstatus;
import com.EventXpert.EventXpert.service.Taskservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private Taskservice taskService;


    @PostMapping("/create-task")
    public ResponseEntity<Taskentity> createTask(@RequestBody Taskentity task) {
        Taskentity created = taskService.createTask(task);
        return ResponseEntity.ok(created);
    }


    @PostMapping("/assign-task/{taskId}/to/{userId}")
    public ResponseEntity<Taskentity> assignTask(@PathVariable Long taskId, @PathVariable Long userId) {
        Taskentity assigned = taskService.assignTask(taskId, userId);
        return ResponseEntity.ok(assigned);
    }


    @PutMapping("/update-status/{taskId}")
    public ResponseEntity<Taskentity> updateStatus(@PathVariable Long taskId, @RequestParam Taskstatus status) {
        Taskentity updated = taskService.updateStatus(taskId, status);
        return ResponseEntity.ok(updated);
    }


    @GetMapping("/all-tasks")
    public ResponseEntity<List<Taskentity>> getAllTasks() {
        List<Taskentity> tasks = taskService.getAllTasks();
        return ResponseEntity.ok(tasks);
    }
}
