package com.fatema.Books.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String price;
    private String imagePath;

    //cascade = CascadeType.PERSIST
    @ManyToOne
    @JoinColumn(name = "dept_id")
    private Category categoryId;

}
