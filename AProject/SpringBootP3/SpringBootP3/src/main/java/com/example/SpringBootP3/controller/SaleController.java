package com.example.SpringBootP3.controller;

import com.example.SpringBootP3.model.sale.Fabric;
import com.example.SpringBootP3.model.sale.Size;
import com.example.SpringBootP3.model.sale.StyleCategories;
import com.example.SpringBootP3.model.sale.Trim;
import com.example.SpringBootP3.repository.sale.*;
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
    private IRawMaterialCat rawMaterialCat;

    @Autowired
    private IStyleCategories styleCategoriesRepo;
    @Autowired
    private ISizeRepo sizeRepo;
    @Autowired
    private ITrim trimRepo;
    @Autowired
    private IFabricName fabricRepo;








//    Style categories start

    @GetMapping("/stylecategories/list")
    public String stylecatList(Model m){
        List<StyleCategories> styleCategoriesList=styleCategoriesRepo.findAll();
        m.addAttribute("title","Style Categories List");
        m.addAttribute("styleCategoriesList", styleCategoriesList);
        return "sale/styleCategoriesList";
    }
    @GetMapping("/stylecategories/addform")
    public String styleCatform(Model m){
        m.addAttribute("styleCategories",new StyleCategories());
        m.addAttribute("title","Style Categories Add Form");
        return "sale/styleCategoriesForm";
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

    @GetMapping("/edit/{id}")
    public String styleCatEdit(@PathVariable int id,Model m){
        StyleCategories categories=styleCategoriesRepo.findById(id).get();
        m.addAttribute("title","Style Categories Edit Form");
        m.addAttribute("styleCategories",categories);
        return "sale/styleCategoriesForm";

    }
//    Style categories end

//    Size start
@GetMapping("/size/list")
public String sizetList(Model m){
    List<Size> sizeList=sizeRepo.findAll();
    m.addAttribute("title","Size List");
    m.addAttribute("sizeList", sizeList);
    return "sale/sizeList";
}
    @GetMapping("/size/addform")
    public String sizeform(Model m){
        m.addAttribute("size",new Size());
        m.addAttribute("title","Create new Size");
        return "sale/sizeForm";
    }
    @PostMapping("/size/save")
    public String sizeSave(@ModelAttribute Size size){
        sizeRepo.save(size);
        return "redirect:/size/list";
    }
    @GetMapping("/size/delete/{id}")
    public String sizeDelete(@PathVariable int id){
        sizeRepo.deleteById(id);
        return "redirect:/size/list";
    }

    @GetMapping("/sizeedit/{id}")
    public String sizeEdit(@PathVariable int id,Model m){
        Size sizename=sizeRepo.findById(id).get();
        m.addAttribute("title","Update Size");
        m.addAttribute("size",sizename);
        return "sale/sizeForm";

    }

//    Size end

//    Trim start
@GetMapping("/trim/list")
public String trimList(Model m){
    List<Trim> trimList=trimRepo.findAll();
    m.addAttribute("title","trim List");
    m.addAttribute("trimList", trimList);
    return "sale/trimList";
}
    @GetMapping("/trim/addform")
    public String trimform(Model m){
        m.addAttribute("trim",new Trim());
        m.addAttribute("title","Create new trim");
        return "sale/trimForm";
    }
    @PostMapping("/trim/save")
    public String trimSave(@ModelAttribute Trim trim){
        trimRepo.save(trim);
        return "redirect:/trim/list";
    }
    @GetMapping("/trim/delete/{id}")
    public String trimDelete(@PathVariable int id){
        trimRepo.deleteById(id);
        return "redirect:/trim/list";
    }

    @GetMapping("/trimedit/{id}")
    public String trimEdit(@PathVariable int id,Model m){
        Trim trimName=trimRepo.findById(id).get();
        m.addAttribute("title","Update trim");
        m.addAttribute("trim",trimName);
        return "sale/trimForm";

    }

//    Trim end

//    Fabric start

    @GetMapping("/fabric/list")
    public String fabricList(Model m){
        List<Fabric> fabricList=fabricRepo.findAll();
        m.addAttribute("title","Fabric List");
        m.addAttribute("fabricList", fabricList);
        return "sale/fabricList";
    }
    @GetMapping("/fabric/addform")
    public String fabricform(Model m){
        m.addAttribute("fabric",new Fabric());
        m.addAttribute("title","Create new Fabric");
        return "sale/fabricForm";
    }
    @PostMapping("/fabric/save")
    public String fabricSave(@ModelAttribute Fabric fabric){
        fabricRepo.save(fabric);
        return "redirect:/fabric/list";
    }
    @GetMapping("/fabric/delete/{id}")
    public String fabricDelete(@PathVariable int id){
        fabricRepo.deleteById(id);
        return "redirect:/fabric/list";
    }

    @GetMapping("/fabricedit/{id}")
    public String fabricEdit(@PathVariable int id,Model m){
        Fabric fabricName=fabricRepo.findById(id).get();
        m.addAttribute("title","Update Fabric");
        m.addAttribute("fabric",fabricName);
        return "sale/fabricForm";

    }

//    Fabric end

//    Raw Material Categories start

//    Raw Material Categories end



}
