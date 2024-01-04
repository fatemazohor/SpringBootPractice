package com.example.testSecuritySpring.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class testSecurity {


    private final UserDetailsService userDetailsService;

    public testSecurity(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    };


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                .authorizeHttpRequests((authorize)->authorize
                        .requestMatchers("/user/**")
                        .hasAnyRole("admin")
                        .anyRequest().authenticated()
                )


                .httpBasic(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults())
                .userDetailsService(userDetailsService);
        return http.build();

        //authorizeRequests() is deprecated but still work.

//        http
//                .authorizeRequests()
//                .requestMatchers("/user/**")
//                .hasAnyRole("admin")
//                .anyRequest().authenticated()
//                .and()
//                .httpBasic(Customizer.withDefaults())
//                .formLogin(Customizer.withDefaults())
//                .userDetailsService(userDetailsService);
//        return http.build();


    }
}
