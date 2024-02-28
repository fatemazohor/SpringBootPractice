package com.fatema.jwtSecurity.service;

import com.fatema.jwtSecurity.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final IUserRepository userRepository;

    @Override
    // Method load user details based on a username(Here, it is email;)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // retrieving user's name by email from IUserRepository based on the email.
        return userRepository.findByEmail(username)
                //If a user is found, return the user details.
                .orElseThrow(()-> new UsernameNotFoundException("No User found with this email."));
    }
}
