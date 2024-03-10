package com.example.loginApp.service;

import com.example.loginApp.model.Role;
import com.example.loginApp.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public interface RoleService {
    Optional<Role> findByName(String name);

    void saveRole(Role role);
}
