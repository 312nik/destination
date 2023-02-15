package com.kata312.service;

import com.kata312.model.Role;
import com.kata312.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {
    private  final RoleRepository roleRepository;
    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    @Override
    public List<Role> getAllRole() {
        return roleRepository.findAll();
    }
    @Override
    public Role getRoleByName(String roleName) {
        return roleRepository.getRoleByName(roleName);
    }
}
