package com.example.ProjectSecurity.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 45,unique = true,nullable = false)
    private String email;

    @Column(length = 64,nullable = false)
    private String password;

    @Column(length = 30,nullable = false)
    private String name;

    @Column(length = 30,nullable = false)
    private String gender;

    @Column(length = 30,nullable = false)
    private String cell;
    @Column(length = 64)
    private String image;

    private boolean is_Enabled;

}
