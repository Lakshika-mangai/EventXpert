package com.EventXpert.EventXpert.service;

import com.EventXpert.EventXpert.entity.Taskentity;
import com.EventXpert.EventXpert.entity.Taskstatus;

import java.util.List;

public interface Taskservice {

    Taskentity createTask(Taskentity task);
    Taskentity assignTask(Long taskId, Long userId);
    Taskentity updateStatus(Long taskId, Taskstatus status);
    List<Taskentity> getTasksByUser(Long userId);
    List<Taskentity> getTasksByUsername(String username);
    Taskentity updateStatusByUser(Long taskId, Taskstatus status, String username);


    List<Taskentity> getAllTasks();
}

