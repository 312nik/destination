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
      private final RoleServiceImpl roleService;

    @Autowired
    public UserController(UserServiceImpl userService,RoleServiceImpl roleService) {

        this.userService = userService;
        this.roleService = roleService;
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
public String createUser(@ModelAttribute User user,@RequestParam String[] roles) {

    
    userService.saveUser(user);
  

    return "/users";
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
        Set <Roles> roles= roleService.findALL();
        model.addAttribute("user", user);
        model.addAttribute("roles", roles);
        
        return "/edit";

    }

 
    
      
   @PostMapping("/edit")
public String updateUser(@ModelAttribute User user,@RequestParam String[] roles) {

    
    userService.saveUser(user);
  

    return "/users";

}

