package com.example.SpringBootP3.service.techPack;

import com.example.SpringBootP3.model.sale.RawMaterial;
import com.example.SpringBootP3.repository.sale.IRawMaterialRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechPackService {

    @Autowired
    private IRawMaterialRepo rawMaterialRepo;

//    public List<RawMaterial> getQueryList(int id){
//        List<RawMaterial> materialList=rawMaterialRepo.findRawMaterialByStyleId(id);
//        return materialList;
//    }
}
