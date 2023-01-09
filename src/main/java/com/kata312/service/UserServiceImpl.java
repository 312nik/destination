package com.kata312.service;

import com.kata312.exception.RecordNotFoundException;
import com.kata312.model.User;
import com.kata312.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class UserServiceImpl  implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bcryptPasswordEncoder;
    @Autowired
    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bcryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bcryptPasswordEncoder = bcryptPasswordEncoder;
    }

    public User findById(Long id) {

        return userRepository.findById(id).orElse(null);

    }




    public List<User> findAll() {
        List<User> result = (List<User>) userRepository.findAll();
        if (result.size() > 0) {
            return result;
        } else {
            return new ArrayList<User>();
        }
    }


    public Optional<User> getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);

            return user;

    }

@Transactional
    public  void deleteUser(Long id)
            throws RecordNotFoundException {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException
                    ("No user record exist for given id");
        }
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Transactional
    public void saveUser(User user) {
          user.setPassword(bcryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);


    }

    @Override
    @Transactional
    public void updateUser(User user) {

        userRepository.save(user);

  }
}




