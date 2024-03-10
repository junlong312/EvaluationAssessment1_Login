package com.example.loginApp.service;

import com.example.loginApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserService {
    Optional<User> findByUsername(String username);
    void saveUser(User user);
}
