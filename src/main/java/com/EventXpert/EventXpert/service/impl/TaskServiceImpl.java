package com.EventXpert.EventXpert.service.impl;

import com.EventXpert.EventXpert.entity.Taskentity;
import com.EventXpert.EventXpert.entity.Taskstatus;
import com.EventXpert.EventXpert.entity.User;
import com.EventXpert.EventXpert.repository.Taskrepository;
import com.EventXpert.EventXpert.repository.UserRepository;
import com.EventXpert.EventXpert.service.Taskservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements Taskservice {

    @Autowired
    private Taskrepository taskRepo;

    @Autowired
    private UserRepository userRepo;

    @Override
    public Taskentity createTask(Taskentity task) {
        return taskRepo.save(task);
    }

    @Override
    public Taskentity assignTask(Long taskId, Long userId) {
        Taskentity task = taskRepo.findById(taskId).orElseThrow(() -> new RuntimeException("Task not found"));
        User user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        task.setAssignee(user);
        return taskRepo.save(task);
    }

    @Override
    public Taskentity updateStatus(Long taskId, Taskstatus status) {
        Taskentity task = taskRepo.findById(taskId).orElseThrow(() -> new RuntimeException("Task not found"));
        task.setStatus(status);
        return taskRepo.save(task);
    }

    @Override
    public List<Taskentity> getTasksByUser(Long userId) {
        return taskRepo.findByAssigneeId(userId);
    }


    @Override
    public List<Taskentity> getAllTasks() {
        return taskRepo.findAll();
    }
    @Override
    public List<Taskentity> getTasksByUsername(String username) {
        User user = userRepo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return taskRepo.findByAssigneeId(user.getId());
    }

    @Override
    public Taskentity updateStatusByUser(Long taskId, Taskstatus status, String username) {
        User user = userRepo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Taskentity task = taskRepo.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        if (!task.getAssignee().getId().equals(user.getId())) {
            throw new RuntimeException("You are not allowed to update this task.");
        }

        task.setStatus(status);
        return taskRepo.save(task);
    }

}
