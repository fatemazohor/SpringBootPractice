package com.example.products.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String styleId;
    private String BuyerId;
    private Date orderDate;
    private Date deliveryDate;
    private String address;
    private String status;
    private String remarks;
    private double paid;
    private double discount;
    private double vat;
}
