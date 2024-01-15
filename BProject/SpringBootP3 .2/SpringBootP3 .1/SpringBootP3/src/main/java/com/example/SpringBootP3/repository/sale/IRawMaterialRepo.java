package com.example.SpringBootP3.repository.sale;

import com.example.SpringBootP3.model.sale.RawMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRawMaterialRepo extends JpaRepository<RawMaterial,Integer> {
}
