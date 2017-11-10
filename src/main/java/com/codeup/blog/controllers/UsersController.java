package com.codeup.blog.controllers;

import com.codeup.blog.models.User;
import com.codeup.blog.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsersController {
    private UsersRepository users;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UsersController(UsersRepository usersRepository, PasswordEncoder passwordEncoder) {
        this.users = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/users/register")
    public String displayRegistrationForm(Model viewModel) {
        viewModel.addAttribute("user", new User());
        return "users/register";
    }

    @PostMapping("/users/register")
    public String registerUser(@ModelAttribute User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        users.save(user);
        return "redirect:/login";
    }
}
