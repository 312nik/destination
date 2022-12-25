package com.kata312.repository;

import com.kata312.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository <User,Long> {
    User findUsersByEmail(String email);


}