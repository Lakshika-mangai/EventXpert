package com.EventXpert.EventXpert.controller;
import com.EventXpert.EventXpert.service.Taskservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.EventXpert.EventXpert.entity.Taskentity;
import com.EventXpert.EventXpert.entity.Taskstatus;


import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    @Autowired
    private Taskservice taskService;

    @PostMapping
    public Taskentity create(@RequestBody Taskentity task) {
        return taskService.createTask(task);
    }

    @PutMapping("/{id}/assign/{userId}")
    public Taskentity assign(@PathVariable Long id, @PathVariable Long userId) {
        return taskService.assignTask(id, userId);
    }

    @GetMapping("/user/{userId}")
    public List<Taskentity> getByUser(@PathVariable Long userId) {
        return taskService.getTasksByUser(userId);
    }

    @PutMapping("/{id}/status")
    public Taskentity updateStatus(@PathVariable Long id, @RequestParam Taskstatus status) {
        return taskService.updateStatus(id, status);
    }
}
