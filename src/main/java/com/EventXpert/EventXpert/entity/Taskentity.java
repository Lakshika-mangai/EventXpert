package com.EventXpert.EventXpert.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tasks")
public class Taskentity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private LocalDate deadline;

    @Enumerated(EnumType.STRING)
    private Taskstatus status;

    @Enumerated(EnumType.STRING)
    private Priorityentity priority;

    @ManyToOne
    @JoinColumn(name = "assignee_id")
    private User assignee;



    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public LocalDate getDeadline() { return deadline; }
    public void setDeadline(LocalDate deadline) { this.deadline = deadline; }

    public Taskstatus getStatus() { return status; }
    public void setStatus(Taskstatus status) { this.status = status; }

    public Priorityentity getPriority() { return priority; }
    public void setPriority(Priorityentity priority) { this.priority = priority; }

    public User getAssignee() { return assignee; }
    public void setAssignee(User assignee) { this.assignee = assignee; }
}

