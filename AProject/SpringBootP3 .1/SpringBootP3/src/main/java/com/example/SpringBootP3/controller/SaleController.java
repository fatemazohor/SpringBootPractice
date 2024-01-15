package com.example.SpringBootP3.controller;

import com.example.SpringBootP3.model.UOM;
import com.example.SpringBootP3.model.Vendors;
import com.example.SpringBootP3.model.sale.*;
import com.example.SpringBootP3.repository.other.IUOMRepo;
import com.example.SpringBootP3.repository.other.IVendorRepo;
import com.example.SpringBootP3.repository.sale.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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

    @Autowired
    private IMeasurementRepo measurementRepo;

    @Autowired
    private IMeasurementAttachmentRepo measurementAttachmentRepo;

    @Autowired
    private IMeasurementSizeRepo measurementSizeRepo;
    @Autowired
    private IRawMaterialRepo iRawMaterialRepo;
    @Autowired
    private IUOMRepo iuomRepo;
    @Autowired
    private IVendorRepo vendorRepo;








//    Style categories start

    @GetMapping("/stylecategories/list")
    public String stylecatList(Model model){
        List<StyleCategories> styleCategoriesList=styleCategoriesRepo.findAll();
        model.addAttribute("title","Style Categories List");
        model.addAttribute("styleCategoriesList", styleCategoriesList);
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
        // Style Categories drop down
        List<StyleCategories> styleCategoriesList=styleCategoriesRepo.findAll();
        m.addAttribute("styleCategoriesList", styleCategoriesList);
        m.addAttribute("styleCategories", new StyleCategories());

        // Size id dropdown
//        List<Size> sizeList=sizeRepo.findAll();
//        m.addAttribute("sizeList", sizeList);
//        m.addAttribute("size", new Size());


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


        // Style Categories drop down
        List<StyleCategories> styleCategoriesList=styleCategoriesRepo.findAll();
        m.addAttribute("styleCategoriesList", styleCategoriesList);
        m.addAttribute("styleCategories", new StyleCategories());

        // Size id dropdown
//        List<Size> sizeList=sizeRepo.findAll();
//        m.addAttribute("sizeList", sizeList);
//        m.addAttribute("size", new Size());


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
//        Style id dropdown
        List<Style> styleList=styleRepo.findAll();
        m.addAttribute("styleList", styleList);
        m.addAttribute("style", new Style());
//        Size id dropdown
        List<Size> sizeList=sizeRepo.findAll();
        m.addAttribute("sizeList", sizeList);
        m.addAttribute("size", new Size());

//Create new StyleSize
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
        //        Style id dropdown
        List<Style> styleList=styleRepo.findAll();
        m.addAttribute("styleList", styleList);
        m.addAttribute("style", new Style());
//        Size id dropdown
        List<Size> sizeList=sizeRepo.findAll();
        m.addAttribute("sizeList", sizeList);
        m.addAttribute("size", new Size());

//Update StyleSize
        StyleSize styleSizeName=styleSizeRepo.findById(id).get();
        m.addAttribute("title","Update Style Size");
        m.addAttribute("styleSize",styleSizeName);
        return "sale/styleSizeForm";

    }

//    Style Size end

//    Measurement start

    @GetMapping("/measurement/list")
    public String measurementList(Model m){
        List<Measurement> measurementList=measurementRepo.findAll();
        m.addAttribute("title","Measurement List");
        m.addAttribute("measurementList", measurementList);
        return "sale/measurementList";
    }
    @GetMapping("/measurement/addform")
    public String measurementForm(Model m){
//        Style id dropdown
        List<Style> styleList=styleRepo.findAll();
        m.addAttribute("styleList", styleList);
        m.addAttribute("style", new Style());

//Create new measurement
        m.addAttribute("measurement",new Measurement());
        m.addAttribute("title","Create new Measurement");

        return "sale/measurementForm";
    }

    @PostMapping("/measurement/save")
    public String measurementSave(@ModelAttribute Measurement measurement){


        measurementRepo.save(measurement);


        return "redirect:/measurement/list";
    }

    @GetMapping("/measurement/delete/{id}")
    public String measurementDelete(@PathVariable int id){
        measurementRepo.deleteById(id);
        return "redirect:/measurement/list";
    }

    @GetMapping("/measurement_edit/{id}")
    public String measurementEdit(@PathVariable int id,Model m){
        //        Style id dropdown
        List<Style> styleList=styleRepo.findAll();
        m.addAttribute("styleList", styleList);
        m.addAttribute("style", new Style());


//Update measurement
        Measurement measurementName=measurementRepo.findById(id).get();
        m.addAttribute("title","Update Measurement");
        m.addAttribute("measurement",measurementName);
        return "sale/measurementForm";

    }

//    Measurement end

//    Measurement Attachment start

    @GetMapping("/measurement_attachment/list")
    public String measurementAttachmentList(Model m){
        List<MeasurementAttachment> measurementAttachmentList=measurementAttachmentRepo.findAll();
        m.addAttribute("title","Measurement Attachment List");
        m.addAttribute("measurementAttachmentList", measurementAttachmentList);
        return "sale/measurementAttachmentList";
    }
    @GetMapping("/measurement_attachment/addform")
    public String measurementAttachmentForm(Model m){
//        Style id dropdown
        List<Style> styleList=styleRepo.findAll();
        m.addAttribute("styleList", styleList);
        m.addAttribute("style", new Style());

//Create new measurement
        m.addAttribute("measurementAttachment",new MeasurementAttachment());
        m.addAttribute("title","Create new Measurement Attachment");

        return "sale/measurementAttachmentForm";
    }

    @PostMapping("/measurement_attachment/save")
    public String measurementAttachmentSave(@ModelAttribute MeasurementAttachment measurementAttachment){


        measurementAttachmentRepo.save(measurementAttachment);


        return "redirect:/measurement_attachment/list";
    }

    @GetMapping("/measurement_attachment/delete/{id}")
    public String measurementAttachmentDelete(@PathVariable int id){
        measurementAttachmentRepo.deleteById(id);
        return "redirect:/measurement_attachment/list";
    }

    @GetMapping("/measurement_attachment_edit/{id}")
    public String measurementAttachmentEdit(@PathVariable int id,Model m){
        //        Style id dropdown
        List<Style> styleList=styleRepo.findAll();
        m.addAttribute("styleList", styleList);
        m.addAttribute("style", new Style());


//Update measurement
       MeasurementAttachment measurementAttachmentName=measurementAttachmentRepo.findById(id).get();
        m.addAttribute("title","Update Measurement Attachment");
        m.addAttribute("measurementAttachment",measurementAttachmentName);
        return "sale/measurementAttachmentForm";

    }

//    Measurement Attachment end

//    Measurement Size start

    @GetMapping("/measurement_size/list")
    public String measurementSizeList(Model m){
        List<MeasurementSize> measurementSizeList=measurementSizeRepo.findAll();
        m.addAttribute("title","Measurement Size List");
        m.addAttribute("measurementSizeList", measurementSizeList);
        return "sale/measurementSizeList";
    }
    @GetMapping("/measurement_size/addform")
    public String measurementsizeForm(Model m){
//        Style id dropdown
        List<Style> styleList=styleRepo.findAll();
        m.addAttribute("styleList", styleList);
        m.addAttribute("style", new Style());

        //        Measurement id dropdown
        List<Measurement> measurementList=measurementRepo.findAll();
        m.addAttribute("measurementList", measurementList);
        m.addAttribute("measurement",new Measurement());

        //        Style Size id dropdown
//        List<StyleSize> styleSizeList=styleSizeRepo.findAll();
//        m.addAttribute("styleSizeList", styleSizeList);
//        m.addAttribute("styleSize",new StyleSize());
        // Size id dropdown
        List<Size> sizeList=sizeRepo.findAll();
        m.addAttribute("sizeList", sizeList);
        m.addAttribute("size", new Size());

//Create new measurement size
        m.addAttribute("measurementSize",new MeasurementSize());
        m.addAttribute("title","Create new Measurement Size");

        return "sale/measurementSizeForm";
    }

    @PostMapping("/measurement_size/save")
    public String measurementSizeSave(@ModelAttribute MeasurementSize measurementSize){


        measurementSizeRepo.save(measurementSize);


        return "redirect:/measurement_size/list";
    }

    @GetMapping("/measurement_size/delete/{id}")
    public String measurementSizeDelete(@PathVariable int id){
        measurementSizeRepo.deleteById(id);
        return "redirect:/measurement_size/list";
    }

    @GetMapping("/measurement_size_edit/{id}")
    public String measurementSizeEdit(@PathVariable int id,Model m){
        //        Style id dropdown
        List<Style> styleList=styleRepo.findAll();
        m.addAttribute("styleList", styleList);
        m.addAttribute("style", new Style());


        //        Measurement id dropdown
        List<Measurement> measurementList=measurementRepo.findAll();
        m.addAttribute("measurementList", measurementList);
        m.addAttribute("measurement",new Measurement());

        //        Style Size id dropdown
//        List<StyleSize> styleSizeList=styleSizeRepo.findAll();
//        m.addAttribute("styleSizeList", styleSizeList);
//        m.addAttribute("styleSize",new StyleSize());

//  Size id dropdown
        List<Size> sizeList=sizeRepo.findAll();
        m.addAttribute("sizeList", sizeList);
        m.addAttribute("size", new Size());


//Update measurement size
        MeasurementSize measurementSizeName=measurementSizeRepo.findById(id).get();
        m.addAttribute("title","Update Measurement Size");
        m.addAttribute("measurementSize",measurementSizeName);
        return "sale/measurementSizeForm";

    }

    //    Measurement Size end

    //    Raw Material start

    @GetMapping("/raw_material/list")
    public String rawMaterialList(Model m){
        List<RawMaterial> rawMaterialList=iRawMaterialRepo.findAll();
        m.addAttribute("title","Raw Material List");
        m.addAttribute("rawMaterialList", rawMaterialList);
        return "sale/rawMaterialList";
    }
    @GetMapping("/raw_material/addform")
    public String rawMaterialForm(Model m){
//        Style id dropdown
        List<Style> styleList=styleRepo.findAll();
        m.addAttribute("styleList", styleList);
        m.addAttribute("style", new Style());

        //       Raw Material Category id dropdown
        List<RawMaterialCat> rawMaterialCategoriesList=rawMaterialCatRepo.findAll();
        m.addAttribute("title","Raw Material Categories List");
        m.addAttribute("rawMaterialCategoriesList", rawMaterialCategoriesList);

        //        Unit of Mesurement id dropdown
        List<UOM> uomList=iuomRepo.findAll();
        m.addAttribute("title","Unit of Measurement List");
        m.addAttribute("uomList", uomList);
        // Vendor id dropdown
        List<Vendors> vendorList=vendorRepo.findAll();
        m.addAttribute("title","Vendor List");
        m.addAttribute("vendorList", vendorList);

//Create new Raw Material
        m.addAttribute("rawMaterial",new RawMaterial());
        m.addAttribute("title","Create new Raw Material");

        return "sale/rawMaterialForm";
    }

    @PostMapping("/raw_material/save")
    public String rawMaterialSave(@ModelAttribute RawMaterial rawMaterial){


        iRawMaterialRepo.save(rawMaterial);


        return "redirect:/raw_material/list";
    }

    @GetMapping("/raw_material/delete/{id}")
    public String rawMaterialDelete(@PathVariable int id){
        iRawMaterialRepo.deleteById(id);
        return "redirect:/raw_material/list";
    }

    @GetMapping("/raw_material_edit/{id}")
    public String rawMaterialEdit(@PathVariable int id,Model m){
        //        Style id dropdown
        List<Style> styleList=styleRepo.findAll();
        m.addAttribute("styleList", styleList);
        m.addAttribute("style", new Style());

        //       Raw Material Category id dropdown
        List<RawMaterialCat> rawMaterialCategoriesList=rawMaterialCatRepo.findAll();
        m.addAttribute("title","Raw Material Categories List");
        m.addAttribute("rawMaterialCategoriesList", rawMaterialCategoriesList);

        //        Unit of Mesurement id dropdown
        List<UOM> uomList=iuomRepo.findAll();
        m.addAttribute("title","Unit of Measurement List");
        m.addAttribute("uomList", uomList);
        // Vendor id dropdown
        List<Vendors> vendorList=vendorRepo.findAll();
        m.addAttribute("title","Vendor List");
        m.addAttribute("vendorList", vendorList);


//Update Raw Material
        RawMaterial rawMaterialName=iRawMaterialRepo.findById(id).get();
        m.addAttribute("title","Update Raw Material");
        m.addAttribute("rawMaterial",rawMaterialName);
        return "sale/rawMaterialForm";

    }

    //    Raw Material end


// Request body method for jquery check
    @GetMapping("/measurement_size/{id}")
    @ResponseBody
    public Optional<MeasurementSize> getmS(@PathVariable int id){
        return measurementSizeRepo.findById(id);
    }
    // this get style by id with other table that has relationship with in measurement size page.
    @GetMapping("/style/{id}")
    @ResponseBody
    public Optional<Style> getStyleById(@PathVariable int id){
        return styleRepo.findById(id);
    }

    @GetMapping("/style_size/{id}")
    @ResponseBody
    public Optional<StyleSize> getmStyleSize(@PathVariable int id){
        return styleSizeRepo.findById(id);
    }





}
