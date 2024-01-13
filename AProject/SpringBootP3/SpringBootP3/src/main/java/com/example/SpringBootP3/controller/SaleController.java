package com.example.SpringBootP3.controller;

import com.example.SpringBootP3.model.sale.*;
import com.example.SpringBootP3.repository.sale.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;
import java.util.List;

@Controller
public class SaleController {

    @Autowired
    private IRawMaterialCat rawMaterialCatRepo;

    @Autowired
    private IStyleCategories styleCategoriesRepo;
    @Autowired
    private ISizeRepo sizeRepo;
    @Autowired
    private ITrim trimRepo;
    @Autowired
    private IFabricName fabricRepo;

    @Autowired
    private IStyle styleRepo;

    @Autowired
    private IStyleSizeRepository styleSizeRepo;








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
@GetMapping("/raw_material_categories/list")
public String rawMaterialcatList(Model m){
    List<RawMaterialCat> rawMaterialCategoriesList=rawMaterialCatRepo.findAll();
    m.addAttribute("title","Raw Material Categories List");
    m.addAttribute("rawMaterialCategoriesList", rawMaterialCategoriesList);
    return "sale/rawMaterialCategoriesList";
}
    @GetMapping("/raw_material_categories/addform")
    public String rawMaterialCatform(Model m){
        m.addAttribute("rawMaterialCategories",new RawMaterialCat());
        m.addAttribute("title","Raw Material Categories Add Form");
        return "sale/rawMaterialCategoriesForm";
    }
    @PostMapping("/raw_material_categories/save")
    public String rawMaterialCatSave(@ModelAttribute RawMaterialCat materialCat){
        rawMaterialCatRepo.save(materialCat);
        return "redirect:/raw_material_categories/list";
    }
    @GetMapping("/raw_material_categories/delete/{id}")
    public String rawMaterialCatDelete(@PathVariable int id){
        rawMaterialCatRepo.deleteById(id);
        return "redirect:/raw_material_categories/list";
    }

    @GetMapping("/raw_material_categories_edit/{id}")
    public String rawMaterialCatEdit(@PathVariable int id,Model m){
        RawMaterialCat categories=rawMaterialCatRepo.findById(id).get();
        m.addAttribute("title","Raw Material Categories Edit Form");
        m.addAttribute("rawMaterialCategories",categories);
        return "sale/rawMaterialCategoriesForm";

    }
//    Raw Material Categories end
//    Style start

    @GetMapping("/style/list")
    public String styleList(Model m){
        List<Style> styleList=styleRepo.findAll();
        m.addAttribute("title","Style List");
        m.addAttribute("styleList", styleList);
        return "sale/styleList";
    }
    @GetMapping("/style/addform")
    public String styleform(Model m){
        List<StyleCategories> styleCategoriesList=styleCategoriesRepo.findAll();
        m.addAttribute("styleCategoriesList", styleCategoriesList);
        m.addAttribute("styleCategories", new StyleCategories());

        m.addAttribute("style",new Style());
        m.addAttribute("title","Create new Style");

//
        return "sale/styleForm";
    }
    @PostMapping("/style/save")
    public String styleSave(@ModelAttribute Style style){

        style.setCreatedAt(new Date());
        styleRepo.save(style);


        return "redirect:/style/list";
    }
    @GetMapping("/style/delete/{id}")
    public String styleDelete(@PathVariable int id){
        styleRepo.deleteById(id);
        return "redirect:/style/list";
    }

    @GetMapping("/styleedit/{id}")
    public String styleEdit(@PathVariable int id,Model m){
        List<StyleCategories> styleCategoriesList=styleCategoriesRepo.findAll();
        m.addAttribute("styleCategoriesList", styleCategoriesList);


        Style stylename=styleRepo.findById(id).get();
        m.addAttribute("title","Update Style");
        m.addAttribute("style",stylename);
        return "sale/styleForm";

    }

//    Style end
//    Style Size start

    @GetMapping("/style_size/list")
    public String styleSizeList(Model m){
        List<StyleSize> styleSizeList=styleSizeRepo.findAll();
        m.addAttribute("title","Style Size List");
        m.addAttribute("styleSizeList", styleSizeList);
        return "sale/styleSizeList";
    }
    @GetMapping("/style_size/addform")
    public String styleSizeform(Model m){
        List<StyleCategories> styleCategoriesList=styleCategoriesRepo.findAll();
        m.addAttribute("styleCategoriesList", styleCategoriesList);
        m.addAttribute("styleCategories", new StyleCategories());

        m.addAttribute("styleSize",new StyleSize());
        m.addAttribute("title","Create new Style Size");

//
        return "sale/styleSizeForm";
    }
    @PostMapping("/style_size/save")
    public String styleSizeSave(@ModelAttribute StyleSize styleSize){


        styleSizeRepo.save(styleSize);


        return "redirect:/style_size/list";
    }
    @GetMapping("/style_size/delete/{id}")
    public String styleSizeDelete(@PathVariable int id){
        styleSizeRepo.deleteById(id);
        return "redirect:/style_size/list";
    }

    @GetMapping("/style_size_edit/{id}")
    public String styleSizeEdit(@PathVariable int id,Model m){
        List<StyleCategories> styleCategoriesList=styleCategoriesRepo.findAll();
        m.addAttribute("styleCategoriesList", styleCategoriesList);


        StyleSize styleSizeName=styleSizeRepo.findById(id).get();
        m.addAttribute("title","Update Style Size");
        m.addAttribute("styleSize",styleSizeName);
        return "sale/styleSizeForm";

    }

//    Style Size end



}
