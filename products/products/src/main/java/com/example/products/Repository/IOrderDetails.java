package com.example.products.Repository;

import com.example.products.Model.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderDetails extends JpaRepository<OrderDetails,Integer > {
}
