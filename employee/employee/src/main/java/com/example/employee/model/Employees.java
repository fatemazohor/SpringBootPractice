package com.example.employee.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "employees")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String ename;
    private String gender;
    private String contact;
    @Column(unique = true,nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    private String address;
    private boolean isEnable;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "em_role",
            joinColumns = @JoinColumn(name = "em_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles =new HashSet<>();

    public void addRole(Role role){
        this.roles.add(role);
    }
    public Employees(String email,String password,String ename){
        this.email = email;
        this.password = password;
        this.ename = ename;
    }



}
