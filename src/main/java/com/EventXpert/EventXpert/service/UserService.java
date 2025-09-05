package com.EventXpert.EventXpert.service;

import com.EventXpert.EventXpert.entity.User;

public interface UserService {

    User registerUser(User user);
    User getUserById(Long id);

}