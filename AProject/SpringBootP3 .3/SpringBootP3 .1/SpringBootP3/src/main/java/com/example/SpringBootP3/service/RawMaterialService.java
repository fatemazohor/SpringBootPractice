package com.example.SpringBootP3.service;

import com.example.SpringBootP3.model.sale.RawMaterial;
import com.example.SpringBootP3.repository.sale.IRawMaterialRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RawMaterialService {
    @Autowired
    private IRawMaterialRepo rawMaterialRepo;

    public RawMaterial getMaterial(int id){
        RawMaterial material=rawMaterialRepo.findById(id).get();
        return material;
    }
}
