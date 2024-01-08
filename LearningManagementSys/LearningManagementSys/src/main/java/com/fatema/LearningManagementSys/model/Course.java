package com.fatema.LearningManagementSys.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, unique = true)
    private String title;
    private String subtitle;
    @Column(nullable = false)
    private String price;
    private String description;
    private String requirement;
    private String goals;

    @ManyToOne
    @JoinColumn
    CourseCategory courseCategory;

}
