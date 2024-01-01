package com.example.ProjectSecurity.repository;

import com.example.ProjectSecurity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepo extends JpaRepository<User,Integer> {
}
