package com.kata312.service;

import com.kata312.model.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findById(Long id);

    void saveUser(User user);

    void update(Long id, User updateUser);

    void deleteUser(User user);
}




