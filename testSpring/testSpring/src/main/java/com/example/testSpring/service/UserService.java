package com.example.testSpring.service;

import com.example.testSpring.model.User;
import com.example.testSpring.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private IUserRepo userRepo;

    public boolean isEmailUnique(String email){
        User userEmail=userRepo.getUserByEmail(email);
        return userEmail==null;
    }

}
