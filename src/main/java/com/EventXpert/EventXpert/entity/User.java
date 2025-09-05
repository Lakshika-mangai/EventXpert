package com.EventXpert.EventXpert.entity;
import jakarta.persistence.*;

import java.util.List;


@Entity

public class User {
    @Id
    @GeneratedValue
    private Long id;


    private String username;
    private String password;
    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "assignee")
    private List<Taskentity> assignedTasks;

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public Role getRole() {
        return role;
    }

    public List<Taskentity> getAssignedTasks() {
        return assignedTasks;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setAssignedTasks(List<Taskentity> assignedTasks) {
        this.assignedTasks = assignedTasks;
    }

}

