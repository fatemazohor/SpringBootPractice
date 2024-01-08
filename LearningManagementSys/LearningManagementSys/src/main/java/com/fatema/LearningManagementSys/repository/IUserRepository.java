package com.fatema.LearningManagementSys.repository;

import com.fatema.LearningManagementSys.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User,Integer> {
    @Query("select u from User u left join fetch u.roles where u.email=:email")
    Optional<User> getUserByEmail(@Param("email") String email);

}
