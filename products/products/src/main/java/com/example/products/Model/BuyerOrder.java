package com.example.products.Model;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@SecondaryTable(name = "buyer_order_details",pkJoinColumns = @PrimaryKeyJoinColumn(name = "order_id"))

public class BuyerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String buyer;
    private String style;
    private String total;

    @Column(name = "lSize", table = "buyer_order_details ")
    private double lSize;
    @Column(name = "mSize", table = "buyer_order_details ")
    private double mSize;
    @Column(name = "sSize", table = "buyer_order_details ")
    private double sSize;

}
