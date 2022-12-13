package com.kata312.controller;

import com.kata312.model.User;
import com.kata312.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller

public class UserController {

    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {

        this.userService = userService;
    }

    @GetMapping("/")
    public String showAllUsers(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "/users";
    }

    @GetMapping("/users")
    public String index(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "/users";
    }


    @GetMapping("/new")
    public String createUserForm(User user) {
        return "/new";
    }

    @PostMapping("/new")
    public String createUser(User user) {

        userService.saveUser(user);
        return "redirect:/users";

    }

    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id, Model model) {
        User user = userService.findById(id);
        userService.deleteUser(user);
        return "redirect:/users";

    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {

        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "/edit";

    }

    @PostMapping("/edit")
    public String update(User user) {

        userService.saveUser(user);
        return "redirect:/users";

    }

}

