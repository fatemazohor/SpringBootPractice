package com.example.testSpring.service;

import com.example.testSpring.model.User;
import com.example.testSpring.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService{


//    private IUserRepo userRepo;
//
//    @Autowired
//    public UserService(IUserRepo userRepo) {
//        this.userRepo = userRepo;
//    }

//    public boolean isEmailUnique(String email){
//        Optional<User> userEmail= userRepo.getUserByEmail(email);
//        return  userEmail==null;
//    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user=userRepo.getUserByEmail(username)
//                .orElseThrow(()-> new UsernameNotFoundException("User Not Found "+username));
//
//        return org.springframework.security.core.userdetails.User
//                .builder()
//                .username(user.getEmail())
//                .password(user.getPassword())
//                .roles(user.getRoles().stream().map(role->role.getName()).toArray(String[]::new))
//                .build();
//    }



}
