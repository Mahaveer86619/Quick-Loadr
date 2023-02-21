package com.SpringApp2.demo.Service;

import com.SpringApp2.demo.Model.AppUser;
import com.SpringApp2.demo.Model.Role;

import java.util.List;

public interface AppUserService {

    AppUser saveUser(AppUser user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String rollName);
    AppUser getUser(String username);
    List<AppUser> getUsers();
}
