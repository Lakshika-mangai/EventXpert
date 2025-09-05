package com.EventXpert.EventXpert.controller;

import com.EventXpert.EventXpert.entity.Taskentity;
import com.EventXpert.EventXpert.entity.Taskstatus;
import com.EventXpert.EventXpert.service.Taskservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/team")
public class UserController {

    @Autowired
    private Taskservice taskService;


    @GetMapping("/my-tasks")
    public ResponseEntity<List<Taskentity>> getUserTasks(Authentication auth) {
        String username = auth.getName();
        List<Taskentity> tasks = taskService.getTasksByUsername(username);
        return ResponseEntity.ok(tasks);
    }


    @PutMapping("/update-status/{taskId}")
    public ResponseEntity<Taskentity> updateStatus(@PathVariable Long taskId,
                                                   @RequestParam Taskstatus status,
                                                   Authentication auth) {
        String username = auth.getName();
        Taskentity updated = taskService.updateStatusByUser(taskId, status, username);
        return ResponseEntity.ok(updated);
    }
}

