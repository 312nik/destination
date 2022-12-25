package com.kata312.repository;

import com.kata312.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Role getRoleById(Long id);
    Role getRoleByName(String roleName);
}
