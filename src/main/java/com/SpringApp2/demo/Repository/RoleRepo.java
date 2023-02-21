package com.SpringApp2.demo.Repository;

import com.SpringApp2.demo.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
