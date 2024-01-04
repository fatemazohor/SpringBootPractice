package com.example.testSecuritySpring.service;

import com.example.testSecuritySpring.model.User;
import com.example.testSecuritySpring.repository.IRoleRepo;
import com.example.testSecuritySpring.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service

public class UserService implements UserDetailsService{




    private IUserRepo userRepo;
    @Autowired
    public UserService(IUserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public boolean isEmailUnique(String email){
        Optional<User> userEmail = userRepo.getUserByEmail(email);
        return userEmail==null;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepo.getUserByEmail(username)
                .orElseThrow(()-> new UsernameNotFoundException("User not found"+username));

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .roles(user.getRole().stream().map(role -> role.getName()).toArray(String[]::new))
                .build();
    }
}
