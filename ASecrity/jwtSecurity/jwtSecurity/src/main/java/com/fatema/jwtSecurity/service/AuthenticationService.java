package com.fatema.jwtSecurity.service;

import com.fatema.jwtSecurity.jwt.JwtService;
import com.fatema.jwtSecurity.model.AuthenticationResponse;
import com.fatema.jwtSecurity.model.Token;
import com.fatema.jwtSecurity.model.User;
import com.fatema.jwtSecurity.repository.ITokenRepository;
import com.fatema.jwtSecurity.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class AuthenticationService {
    private final IUserRepository userRepository;

    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final ITokenRepository tokenRepository;

    private final AuthenticationManager authenticationManager;

    public AuthenticationService(
            IUserRepository userRepository,
            PasswordEncoder passwordEncoder,
            JwtService jwtService,
            ITokenRepository tokenRepository,
            AuthenticationManager authenticationManager) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.tokenRepository = tokenRepository;
        this.authenticationManager = authenticationManager;
    }
    // Method to register a new user
    public AuthenticationResponse register(User request){
        // Check if the user already exists
        if(userRepository.findByEmail(request.getUsername()).isPresent()){
            return new AuthenticationResponse(null, "User already exists.");
        }
        //Create a new user entity and save it to the database
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole());
        userRepository.save(user);
        // Generate JWT token for the newly registered user
        String jwt = jwtService.generateToken(user);
        // Save the token to the token repository
        saveUserToken(jwt,user);
        return new AuthenticationResponse(jwt,"User registration was successful");
    }
    // Method to authenticate a user
    public AuthenticationResponse authenticate(User request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        //Retrieve the user from the database
        User user = userRepository.findByEmail(request.getUsername()).orElseThrow();
        // Generate JWT token for the authenticated user
        String jwt = jwtService.generateToken(user);
        // Revoke all existing tokens for this user
        revokeAllTokenByUser(user);
        // Save the new token to the token repository
        saveUserToken(jwt, user);
        return new AuthenticationResponse(jwt,"User Login was successful");

    }

    // Method to revoke all existing  tokens for a user
    private void revokeAllTokenByUser(User user){
        List<Token> validTokens = tokenRepository.findAllTokenByUser(user.getId());
        if(validTokens.isEmpty()){
            return;
        }
        //Set all valid tokens for the user to logged out
        validTokens.forEach(token -> {
            token.setLoggedOut(true);
        });
        // Save the change to the tokens in the token repository
        tokenRepository.saveAll(validTokens);
    }
    //Method to save a token for a user to the token repository
    private void saveUserToken(String jwt, User user){
        Token token = new Token();
        token.setToken(jwt);
        token.setLoggedOut(false);
        token.setUserId(user);
        tokenRepository.save(token);
    }
}
