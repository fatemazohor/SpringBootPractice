package com.example.SpringBootP3.controller;

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
//        List<RawMaterial> materialList=techPackService.getQueryList(id);
//        m.addAttribute("materialList",materialList);
        return "other/techpage";
    }
}
