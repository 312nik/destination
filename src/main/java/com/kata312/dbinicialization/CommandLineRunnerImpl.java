package com.kata312.dbinicialization;

import com.kata312.model.Role;
import com.kata312.model.User;
import com.kata312.repository.RoleRepository;
import com.kata312.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public CommandLineRunnerImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if(userRepository.findAll().isEmpty()){
        roleRepository.save(new Role("ROLE_ADMIN"));
        roleRepository.save(new Role("ROLE_USER"));
        Role adminRole = roleRepository.getRoleById(1L);
        Role userRole = roleRepository.getRoleById(2L);
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminRoles.add(userRole);
        Set <Role> userRoles= new HashSet<>();
        userRoles.add(userRole);

        User admin= new User();
        admin.setName("Admin");
        admin.setLastName("Adminov");
        admin.setEmail("admin@mail.ru");
        admin.setAge(40);
        admin.setPassword("$2a$12$zLqrapx439Jx5ckj7ttE3.EbNYu0a.U8S2IoKsf.z63kE4hakQlSu"); //admin
        admin.setRoles(adminRoles);
        userRepository.save(admin);

        User user = new User();
        user.setName("User");
        user.setLastName("Userov");
        user.setAge(30);
        user.setEmail("user@mail.ru");
        user.setPassword("$2a$12$KfgcyoMND4XibkwHgKmMX.xqTxnfalroJaOl2ewvxVUWK5sqd/tSi"); //user
        user.setRoles(userRoles);
        userRepository.save(user);}

    }
}
