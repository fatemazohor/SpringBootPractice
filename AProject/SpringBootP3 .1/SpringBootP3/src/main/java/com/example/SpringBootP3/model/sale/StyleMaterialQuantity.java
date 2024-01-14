package com.example.SpringBootP3.model.sale;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class StyleMaterialQuantity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "style_id")
    Style styleid;
//    add after makeing raw material table
//    @ManyToOne
//    @JoinColumn(name = "raw_material_id")
//    RawMaterialCat rawMaterialCat;
}
