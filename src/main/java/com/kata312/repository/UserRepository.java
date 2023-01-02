package com.kata312.repository;

import com.kata312.model.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;


@Repository
public interface UserRepository extends JpaRepository <User,Long> {

    @EntityGraph (attributePaths = "roles")

    User findUserByEmail(String email);



}