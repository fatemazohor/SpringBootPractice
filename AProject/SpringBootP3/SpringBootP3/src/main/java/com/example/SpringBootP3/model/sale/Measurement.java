package com.example.SpringBootP3.model.sale;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Measurement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String codeName;
    private String name;
    private String tolerance;

    @ManyToOne
    @JoinColumn(name = "style_id")
    private Style styleId;

}
