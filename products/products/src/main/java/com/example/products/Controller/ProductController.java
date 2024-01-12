package com.example.products.Controller;

import com.example.products.Model.Categories;
import com.example.products.Model.Products;
import com.example.products.Services.CategoriesService;
import com.example.products.Services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductsService service;
    @Autowired
    private CategoriesService catservice;
    @GetMapping("")
    public String getAllPro(Model m){
        List<Products> productsList=service.getAllProducts();
        m.addAttribute("productList", productsList);
        m.addAttribute("title", "productsList");
        return "Product";
    }

    @GetMapping("/add")
    public String addPro(Model m){
        List<Categories> categoriesList=catservice.getAllCategories();
        m.addAttribute("categoryList", categoriesList);
        m.addAttribute("category", new Categories());



        m.addAttribute("product", new Products());
        m.addAttribute("title", "products from");
        return "FormProduct";
    }
    @PostMapping("/save")
    public String saveProduct(@ModelAttribute Products products){
        service.saveProducts(products);
        return "redirect:/product";

    }
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id){
        service.deleteProducts(id);
        return "redirect:/product";
    }

    @GetMapping("/update/{id}")
    public String updateProduct(@PathVariable int id,Model m){
        Products product = service.findProduct(id);
        m.addAttribute("product",product);


        List<Categories> categoriesList=catservice.getAllCategories();
        m.addAttribute("categoryList", categoriesList);

        return "FormProduct";
    }
}
