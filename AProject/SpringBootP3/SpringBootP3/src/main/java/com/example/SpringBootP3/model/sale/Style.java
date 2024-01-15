package com.example.SpringBootP3.model.sale;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

//    @OneToMany(mappedBy = "style")
//    private List<Size> styleSize;
    @ManyToMany
    @JoinTable(
            name = "style_related_size",
            joinColumns =@JoinColumn(name="style_id"),
            inverseJoinColumns = @JoinColumn(name="size_id")
    )
    private Set<Size> styleSize=new HashSet<>();




}
