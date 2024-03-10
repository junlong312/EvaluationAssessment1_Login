package com.example.loginApp.controller;

import com.example.loginApp.model.User;
import com.example.loginApp.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/welcome")
public class WelcomeController {

    private final UserRepo userRepo;

    @Autowired
    public WelcomeController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping
    public String welcomePage(Authentication authentication, Model model) {
        if (authentication != null && authentication.isAuthenticated()) {
            String username = authentication.getName();

            Optional<User> userOptional = userRepo.findByUsername(username);
            userOptional.ifPresent(user -> {
                model.addAttribute("name", user.getFullName());
                model.addAttribute("username", user.getUsername());
                model.addAttribute("role", authentication.getAuthorities().isEmpty() ? null : authentication.getAuthorities().iterator().next().getAuthority());
            });
        }
        return "welcome";
    }
}
