package com.emranhss.demo.service;

import com.emranhss.demo.model.User;
import com.emranhss.demo.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private IUserRepo userRepo;

    public boolean isEmailUnique(String email){
        User userEmail= userRepo.getUserByEmail(email);
        return  userEmail==null;
    }


}
