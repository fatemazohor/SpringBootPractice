package com.example.testSecuritySpring.repository;

import com.example.testSecuritySpring.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IToken extends JpaRepository<Token,Long> {
   Token findByConfirmationToken(String token);
}
