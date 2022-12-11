package com.kata312.service;

import com.kata312.model.User;
import com.kata312.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UserServiceImpl  implements UserService{

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findById(Long id) {

        return userRepository.findById(id).orElse(null);

    }

    public List<User> findAll() {

        return userRepository.findAll();

    }

    public void saveUser(User user) {

        userRepository.save(user);

    }

    public void update(Long id, User updateUser) {

        updateUser.setId(id);
        userRepository.save(updateUser);
    }

    public void deleteUser(Long id) {

        userRepository.deleteById(id);

    }
}
