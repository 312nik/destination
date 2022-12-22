package com.kata312.repository;

import com.kata312.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
  
  @EntityGraph(attribuParth="roles")
  
  User findUsersByEmail(String email);

}
