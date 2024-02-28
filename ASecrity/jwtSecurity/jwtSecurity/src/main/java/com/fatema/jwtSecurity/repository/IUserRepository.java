package com.fatema.jwtSecurity.repository;

import com.fatema.jwtSecurity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String username);
}
