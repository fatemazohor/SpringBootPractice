package com.example.testSpring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
@Column(unique = true,nullable = false)
    private String email;
@Column(nullable = false)
    private String password;
@Column(nullable = false)
    private String name;
    private String gender;
    private String cell;
    private String dob;
    private String image;
    private boolean isEnabled;


    @ManyToMany
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="role_id")

    )

    private Set<Role> role=new HashSet<>();


    public User(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public void addrole(Role roles) {
        this.role.add(roles);
    }
}
