package com.kata312.controller;

import com.kata312.model.User;
import com.kata312.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller

public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {

        this.userService = userService;
    }

    @GetMapping("/users")
    public String index(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/new")
    public String newPerson(User user) {
        return "/new";
    }

    @PostMapping("/new")
    public String create(User user) {

        userService.saveUser(user);
        return "redirect:/users";

    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {

        userService.deleteUser(id);
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

