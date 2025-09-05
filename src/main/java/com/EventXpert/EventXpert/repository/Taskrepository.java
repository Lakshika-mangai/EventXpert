package com.EventXpert.EventXpert.repository;

import com.EventXpert.EventXpert.entity.Taskentity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface Taskrepository extends JpaRepository<Taskentity, Long> {
    List<Taskentity> findByAssigneeId(Long assigneeId);
}
