package com.SpringApp2.demo.Service;

import com.SpringApp2.demo.Model.AppUser;
import com.SpringApp2.demo.Model.Role;
import com.SpringApp2.demo.Repository.AppUserRepo;
import com.SpringApp2.demo.Repository.RoleRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class ServiceImplementation implements AppUserService{

    private final AppUserRepo userRepo;
    private final RoleRepo roleRepo;
    @Override
    public AppUser saveUser(AppUser user) {
        log.info("Saving new User {} to Database.", user.getName());
        return userRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new Role {} to Database.", role.getName());
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, String rollName) {
        log.info("Adding new Role {} to User {}.", rollName , username);
        AppUser user = userRepo.findByUsername(username);
        Role role = roleRepo.findByName(rollName);
        user.getRole().add(role);
    }

    @Override
    public AppUser getUser(String username) {
        log.info("Fetching user {}", username);
        return userRepo.findByUsername(username);
    }

    @Override
    public List<AppUser> getUsers() {
        log.info("Fetching all users");
        return userRepo.findAll();
    }
}
