package com.example.SpringBootP3.model.sale;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Style {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String code;
    private String description;
    private Date CreatedAt;
    private Date UpdatedAt=new Date();

    @ManyToOne
    @JoinColumn(name = "style_cat_id")
    public StyleCategories categoriesId;

}
