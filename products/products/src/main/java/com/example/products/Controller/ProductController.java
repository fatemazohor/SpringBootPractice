package com.example.products.Controller;

import com.example.products.Model.Categories;
import com.example.products.Model.Products;
import com.example.products.Repository.Iproducts;
import com.example.products.Services.CategoriesService;
import com.example.products.Services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductsService service;
    @Autowired
    private CategoriesService catservice;

    @Autowired
    private Iproducts iproductsRepo;

    @GetMapping("")
    public String getAllPro(Model m){
        List<Products> productsList=service.getAllProducts();
        m.addAttribute("productList", productsList);
        m.addAttribute("title", "productsList");
        return "Product";
    }


//    display image on table start

    @GetMapping("/display")
    public ResponseEntity<byte[]> getDisplayImage(@RequestParam("id") int id) throws IOException{
//        Products products=service.findProduct(id);
//        if (products.isPresent()){}
        Optional<Products> products=iproductsRepo.findById(id);
        if (products.isPresent()){
            Products proImage=products.get();
            //select directory

            String uploadDirectory="src/main/resources/static/assets/image/product/";
            String fileName=proImage.getImage();
            String filePath=Paths.get(uploadDirectory,fileName).toString();


            try {
                Path path=Path.of(filePath);
                byte[] imageByte=Files.readAllBytes(path);
                return ResponseEntity
                        .ok()
                        .contentType(MediaType.IMAGE_JPEG)
                        .header(HttpHeaders.CONTENT_DISPOSITION,"inline+ filename="
                        +path.getFileName().toString())
                        .body(imageByte);

            } catch (IOException e){
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            }

        }
        return ResponseEntity.notFound().build();
    }

//    display image on table end




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
    public String saveProduct(@ModelAttribute @Validated Products products, BindingResult result, @RequestParam("image"
    )MultipartFile image)throws IOException, SQLException {

//        save Image start

        if(!image.isEmpty()){
            byte[] bytes= image.getBytes();
            String originalFileName=image.getOriginalFilename();
            //timestamp for unique filename
            Long timestamp=System.currentTimeMillis();
            //file extension
            String fileExtension=originalFileName.substring(originalFileName.lastIndexOf("."));
            //new file name
            String newFileName="product_"+timestamp+fileExtension;
            // set file name to send to database
            products.setImage(newFileName);
            //save image to specific directory
            String uploadDirectory="src/main/resources/static/assets/image/product/";
            Path uploadPath= Paths.get(uploadDirectory);
//            Path uploadPath= Path.of(uploadDirectory);
            //CREATE directory image if not exist
            if(!Files.exists(uploadPath)){
                Files.createDirectories(uploadPath);
            }
            Path filePath=uploadPath.resolve(newFileName);
            Files.write(filePath,bytes);


        }

//        save Image end


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
