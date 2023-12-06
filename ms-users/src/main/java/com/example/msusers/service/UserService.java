package com.example.msusers.service;

import com.example.msusers.domain.User;
import com.example.msusers.repository.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findById(String id_user) {
        return userRepository.findById(id_user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
