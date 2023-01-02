package com.kata312.controller;

import com.kata312.model.Role;
import com.kata312.model.User;
import com.kata312.service.RoleServiceImpl;
import com.kata312.service.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller

public class AdminController {

    private final UserServiceImpl userService;
    private final RoleServiceImpl roleService;

    @Autowired
    public AdminController(UserServiceImpl userService, RoleServiceImpl roleService) {

        this.userService = userService;
        this.roleService = roleService;

    }



    @GetMapping("/admin")
    public String showAllUsers(Model model, Principal principal) {
        String userMail = principal.getName();
        User user= userService.findUserByEmail(userMail);
        List<User> users = userService.findAll();
        User newUser=new User();
        model.addAttribute("userPrincipal",user);
        model.addAttribute("users", users);
        model.addAttribute("newUser",newUser);
        return "/admin";



    }


   /* @GetMapping("admin/new")
    public String createUserForm(User user,Model model) {

        List <Role> roles= roleService.getAllRole();
        model.addAttribute("roles",roles);

        return "admin/new";
    }*/

    @PostMapping("admin/new")
    public String createUser(@ModelAttribute("newUser")  User user, RedirectAttributes redirectAttributes) {
        User userNew= userService.findUserByEmail(user.getEmail());

        if (userNew !=null){
            redirectAttributes.addFlashAttribute("message",
                    "A user with such an email already exists!");
        }



    userService.saveUser(user);
        return "redirect:/admin";

    }

    @PostMapping("/admin/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id, Model model) {
        User user = userService.findById(id);
        userService.deleteUser(user);
        return "redirect:/admin/users";

    }

    @GetMapping("/admin/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        List<Role> roles=  roleService.getAllRole();
        model.addAttribute("roles",roles);
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "/admin/edit";

    }

    @PostMapping("/admin/edit")
    public String update(User user,@RequestParam(value = "selectRoles") String[] selectRole) {
        Set <Role> roles =  new HashSet<>();
        for (String role: selectRole ) {
            roles.add(roleService.getRoleByName(role));
        }
        user.setRoles(roles);

        userService.saveUser(user);
        return "redirect:/admin/users";

    }

}




