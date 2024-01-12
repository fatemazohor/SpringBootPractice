package com.example.SpringBootP3.controller;

import com.example.SpringBootP3.model.sale.StyleCategories;
import com.example.SpringBootP3.repository.sale.IStyleCategories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SaleController {
    @Autowired
    private IStyleCategories styleCategoriesRepo;




//    Style categories start

    @GetMapping("/stylecategories/list")
    public String stylecatList(Model m){
        List<StyleCategories> styleCategoriesList=styleCategoriesRepo.findAll();
        m.addAttribute("title","Style Categories List");
        m.addAttribute("styleCategoriesList", styleCategoriesList);
        return "styleCategoriesList";
    }
    @GetMapping("/stylecategories/addform")
    public String styleCatform(Model m){
        m.addAttribute("styleCategories",new StyleCategories());
        m.addAttribute("title","Style Categories Add Form");
        return "styleCategoriesForm";
    }
    @PostMapping("/stylecategories/save")
    public String styleCatSave(@ModelAttribute StyleCategories styleCategories){
        styleCategoriesRepo.save(styleCategories);
        return "redirect:/stylecategories/list";
    }
    @GetMapping("/stylecategories/delete/{id}")
    public String styleCatDelete(@PathVariable int id){
        styleCategoriesRepo.deleteById(id);
        return "redirect:/stylecategories/list";
    }

    @GetMapping("/stylecategories/edit/{id}")
    public String styleCatEdit(@PathVariable int id,Model m){
        StyleCategories categories=styleCategoriesRepo.findById(id).get();
        m.addAttribute("title","Style Categories Edit Form");
        m.addAttribute("styleCategories",categories);
        return "styleCategoriesEditForm";

    }
//    Style categories end

}
