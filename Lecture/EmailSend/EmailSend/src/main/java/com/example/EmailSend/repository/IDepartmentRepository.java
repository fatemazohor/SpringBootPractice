package com.example.EmailSend.repository;

import com.example.EmailSend.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDepartmentRepository extends JpaRepository<Department,Integer> {
    Department findBydName(String dName);
}
