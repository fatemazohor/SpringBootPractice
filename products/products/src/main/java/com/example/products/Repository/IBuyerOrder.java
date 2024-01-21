package com.example.products.Repository;

import com.example.products.Model.BuyerOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBuyerOrder extends JpaRepository<BuyerOrder,Integer> {
}
