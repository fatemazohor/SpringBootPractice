package com.example.employee.repository;

import com.example.employee.model.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Iemployee extends JpaRepository<Employees, Integer> {
//    @Query("select em from Employees em  where em.email=:email")
    Employees findByEmail(@Param("email") String email);
}
