package com.kata312.controller;

import com.kata312.exception.UserEmailDuplicateException;
import com.kata312.exception.UserErrorResponse;
import com.kata312.exception.UserNotFoundException;
import com.kata312.exception.RecordNotFoundException;
import com.kata312.model.User;
import com.kata312.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AdminRestController {
    private final UserService userService;

    public AdminRestController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/admin")
    public ResponseEntity<User> showAdminPersonalPage(Principal principal) {
        User user = userService.findUserByEmail(principal.getName());
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> showAdminGeneralPage() {
        List<User> users = userService.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> showUser(@PathVariable("id") Long id) {
        User user = userService.findById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<HttpStatus> addUser(@RequestBody User user) {

        userService.saveUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/users/{id}")
    public ResponseEntity<HttpStatus> editUser(@RequestBody User user) {

        userService.updateUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

   @DeleteMapping("/users/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") Long id) throws RecordNotFoundException {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @ExceptionHandler
    private ResponseEntity<UserErrorResponse> handleException(UserNotFoundException e){
        UserErrorResponse response = new UserErrorResponse("User with this id was not found ");
        return  new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    };

    @ExceptionHandler
    private ResponseEntity<UserErrorResponse> handleException(UserEmailDuplicateException e){
        UserErrorResponse response = new UserErrorResponse("User with this Email  already  exist");
        return  new ResponseEntity<>(response, HttpStatus.CONFLICT);
    };


}
