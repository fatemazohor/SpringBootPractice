package com.example.SpringBootP3.controller;

import com.example.SpringBootP3.model.sale.MeasurementAttachment;
import com.example.SpringBootP3.model.sale.MeasurementDetails;
import com.example.SpringBootP3.model.sale.RawMaterial;
import com.example.SpringBootP3.model.sale.Style;
import com.example.SpringBootP3.repository.sale.IStyle;
import com.example.SpringBootP3.service.techPack.TechPackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Random;

@Controller
public class HomeController {
    @Autowired
    private IStyle iStyleRepo;
    @Autowired
    private TechPackService techPackService;

    @GetMapping("/home")
    private String home(){
        return "index";
    }
    @GetMapping("/page")
    private String page(){
        return "page";
    }
    @GetMapping("/page2")
    private String page2(){
        return "page2";
    }


//    Tech pack page Data
    @GetMapping("/techpage/{id}")
    private String techpage(@PathVariable int id, Model m){
        Style styleData=iStyleRepo.findById(id).get();
        m.addAttribute("styleData",styleData);

// getQueryList method
//        List<RawMaterial> materialList=techPackService.getQueryList(Integer.valueOf(id));
//        m.addAttribute("materialList",materialList);


//        find by style id method from raw material table
        List<RawMaterial> rawMaterialList=techPackService.getTechPack(id);
        m.addAttribute("rawMaterialList",rawMaterialList);

        //find by style and raw material table join query
//        List<Style> styleMaterialList=techPackService.getStyleMaterial(id);
//        m.addAttribute("styleMaterialList",styleMaterialList);

        //Measurement details list to tech pack
        List<MeasurementDetails> measurementDetailsList=techPackService.getMeasuermentDetList(id);
        m.addAttribute("measurementDetailsList",measurementDetailsList);
        //Measurement Att or sketch to tech pack
        List<MeasurementAttachment> measurementAttachmentList=techPackService.getMSketchList(id);
        m.addAttribute("measurementAttachmentList",measurementAttachmentList);
        return "other/techpage";
    }

    //demo data check page --work
    @GetMapping("/demo_page/{id}")
    public String demoCheck(@PathVariable int id,Model m){
        List<MeasurementDetails> measurementDetailsList=techPackService.getMeasuermentDetList(id);
        m.addAttribute("measurementDetailsList",measurementDetailsList);
        return "other/demopage";

    }
}
