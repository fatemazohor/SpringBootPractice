package com.example.ProjectSecurity.repository;

import com.example.ProjectSecurity.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepo extends JpaRepository<Role,Integer> {

}
