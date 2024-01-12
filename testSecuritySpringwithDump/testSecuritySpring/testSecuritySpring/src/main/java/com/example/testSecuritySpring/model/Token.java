package com.example.testSecuritySpring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Token{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String confirmationToken;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @OneToOne(fetch = FetchType.EAGER, targetEntity = User.class)
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    public Token(User user) {
        this.user = user;
        this.confirmationToken= UUID.randomUUID().toString();
        this.createDate=new Date();
    }

}
