package com.example.loginApp.service;

import com.example.loginApp.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.loginApp.model.Role;

import java.util.Optional;

public class RoleServiceImpl implements RoleService{

    private final RoleRepo roleRepo;

    @Autowired
    public RoleServiceImpl(RoleRepo roleRepo){
        this.roleRepo = roleRepo;
    }

    @Override
    public Optional<Role> findByName(String name) {
        return roleRepo.findByName(name);
    }
    @Override
    public void saveRole(Role role) {
        roleRepo.save(role);
    }
}
