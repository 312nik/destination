package com.kata312.service;

import com.kata312.exception.RecordNotFoundException;
import com.kata312.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(Long id);
    void saveUser(User user);
    void updateUser(User user);
    void deleteUser(Long id) throws RecordNotFoundException;
    User findUserByEmail(String email);
}




