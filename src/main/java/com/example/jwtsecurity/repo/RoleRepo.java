package com.example.jwtsecurity.repo;

import com.example.jwtsecurity.domain.Role;
import com.example.jwtsecurity.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {

    Role findByName(String name);
}
