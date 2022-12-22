package com.kata312.controller;

import com.kata312.model.User;
import com.kata312.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller

public class OneUserController {

    private final UserServiceImpl userService;
     
    @Autowired
    public UserController(UserServiceImpl userService) {

        this.userService = userService;
      
    }

    @GetMapping("/user")
    public String showUsers(Model model) {
        User user = userService.findByEmail(principal.getName);
         
        model.addAttribute("user", user);
        return "/user";
    }
}

