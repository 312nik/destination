package com.kata312.service;

import com.kata312.model.Role;
import java.util.List;

public interface RoleService {
    List<Role> getAllRole();
    Role getRoleByName(String roleName);
}