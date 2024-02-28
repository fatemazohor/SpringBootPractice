package com.fatema.jwtSecurity.repository;

import com.fatema.jwtSecurity.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ITokenRepository extends JpaRepository<Token,Long> {
    Optional<Token> findByToken(String token);


    @Query(" select t from Token t inner join User u on t.userId.id = u.id where t.userId.id =:userId and t.loggedOut = false ")
    List<Token> findAllTokenByUser(Long userId);

}
