package com.example.products.Repository;

import com.example.products.Model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrders extends JpaRepository<Orders,Integer> {
}
