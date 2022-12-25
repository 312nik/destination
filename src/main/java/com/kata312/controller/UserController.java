package com.kata312.controller;

import com.kata312.model.User;
import com.kata312.service.RoleServiceImpl;
import com.kata312.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserServiceImpl userService;
    private final RoleServiceImpl roleService;
    @Autowired
    public UserController(UserServiceImpl userService, RoleServiceImpl roleService) {

        this.userService = userService;
        this.roleService = roleService;

    }



    @GetMapping("/")
    public String showUsers(Model model) {
       /* User user = userService.findById(Long id);*/
        /*model.addAttribute("user", user);*/
        return "/user";
    }

}
