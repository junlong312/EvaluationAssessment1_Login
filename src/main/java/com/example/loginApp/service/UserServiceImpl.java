package com.example.loginApp.service;

import com.example.loginApp.model.User;
import com.example.loginApp.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UserServiceImpl implements UserService{

    private final UserRepo userRepo;

    @Autowired
    public UserServiceImpl (UserRepo userRepo){
        this.userRepo = userRepo;
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public void saveUser(User user) {
        userRepo.save(user);
    }
}
