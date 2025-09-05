package com.EventXpert.EventXpert.service.impl;

import com.EventXpert.EventXpert.entity.User;
import com.EventXpert.EventXpert.repository.UserRepository;
import com.EventXpert.EventXpert.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
