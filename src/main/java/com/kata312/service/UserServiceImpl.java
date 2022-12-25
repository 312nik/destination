package com.kata312.service;

import com.kata312.model.User;
import com.kata312.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service

public class UserServiceImpl  implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder bcryptPasswordEncoder;
    @Autowired
    public UserServiceImpl(UserRepository userRepository,RoleRepository roleRepository,BCryptPasswordEncoder bcryptPasswordEncoder) {
        this.userRepository = userRepository;
         this.roleRepository = roleRepository;
        this.bcryptPasswordEncoder = bcryptPasswordEncoder;
        
    }

    public User findById(Long id) {

        return userRepository.findById(id).orElse(null);

    }

    public List<User> findAll() {

        return userRepository.findAll();

    }
    @Transactional
    public void saveUser(User user) {
        user.setPassword(bcryptPasswordEncoder.encode(user.getPassword()));

        userRepository.save(user);

    }


    @Transactional
    public void update(Long id, User updateUser) {

        updateUser.setId(id);
        userRepository.save(updateUser);
    }
    @Transactional
    public void deleteUser(User user) {

        userRepository.delete(user);

    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user= userRepository.findUsersByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }
}