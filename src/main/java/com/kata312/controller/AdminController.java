package com.kata312.controller;

import com.kata312.model.Role;
import com.kata312.model.User;
import com.kata312.service.RoleServiceImpl;
import com.kata312.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping ("/admin")
public class AdminController {

    private final UserServiceImpl userService;
    private final RoleServiceImpl roleService;
    @Autowired
    public AdminController(UserServiceImpl userService, RoleServiceImpl roleService) {

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
    public String createUserForm(User user,Model model) {
        user = new User();
        List <Role> roles= roleService.getAllRole();
        model.addAttribute("roles",roles);
        model.addAttribute("user",user);
        return "/new";
    }

    @PostMapping("/new")
    public String createUser(@ModelAttribute("user") User user,@RequestParam(value = "selectRoles") String[] selectRole) {
        Set <Role> roles =  new HashSet<>();
        for (String role: selectRole ) {
           roles.add(roleService.getRoleByName(role));
        }
        user.setRoles(roles);
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
        List<Role> roles=  roleService.getAllRole();
        model.addAttribute("roles",roles);
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "/edit";

    }

    @PostMapping("/edit")
    public String update(User user,@RequestParam(value = "selectRoles") String[] selectRole) {
        Set <Role> roles =  new HashSet<>();
        for (String role: selectRole ) {
            roles.add(roleService.getRoleByName(role));
        }
        user.setRoles(roles);

        userService.saveUser(user);
        return "redirect:/users";

    }

}




