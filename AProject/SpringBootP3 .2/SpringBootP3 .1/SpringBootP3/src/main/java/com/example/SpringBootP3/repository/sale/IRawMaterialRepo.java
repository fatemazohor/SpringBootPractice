package com.example.SpringBootP3.repository.sale;

import com.example.SpringBootP3.model.sale.RawMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRawMaterialRepo extends JpaRepository<RawMaterial,Integer> {
//    @Query("select raw from RawMaterial raw where raw.styleId=:styleId order by raw.rawMaterialCatId")
//    @Query("select raw from RawMaterial raw where raw.styleId=?1")
//    public List<RawMaterial> findRawMaterialByStyleId(Integer styleId);
}
