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
        return userRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, String rollName) {
        AppUser user = userRepo.findByUsername(username);
        Role role = roleRepo.findByName(rollName);
        user.getRole().add(role);
    }

    @Override
    public AppUser getUser(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public List<AppUser> getUsers() {
        return userRepo.findAll();
    }
}
