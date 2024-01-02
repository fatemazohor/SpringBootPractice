package com.example.ProjectSecurity.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class ProjectSecurity {

    @Bean
    public SecurityFilterChain chain(HttpSecurity http) throws Exception{
        http
                .authorizeHttpRequests((authorize)->authorize
                        .requestMatchers("/admin/student/**").authenticated()
                )
                .authorizeHttpRequests((authorize)->authorize
                        .requestMatchers("/home/**").permitAll()
                )
                .httpBasic(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults());
        return http.build();

    }

}
