package com.fatema.Books.restController;

import com.fatema.Books.model.Book;
import com.fatema.Books.model.Category;
import com.fatema.Books.model.ProductImage;
import com.fatema.Books.repository.IBook;
import com.fatema.Books.repository.ICategory;
import com.fatema.Books.repository.IProductImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class BookRestController {

    @Autowired
    private IBook bookRepo;

    @Autowired
    private ICategory categoryRepo;
    @Autowired
    private IProductImage productImageRepo;


//    swagger link: http://localhost:8086/swagger-ui/index.html#/


    @GetMapping("/book")
    public List<Book> getBook(){
        return bookRepo.findAll();
    }

    @PostMapping("/book")
    public ResponseEntity<Book>  savebook(@RequestBody Book book){

        String categoryName = book.getCategoryId().getCateName();
        Category category=categoryRepo.findByCateName(categoryName);
        book.setCategoryId(category);
        bookRepo.save(book);

        return ResponseEntity.ok(book);
    }

    @PutMapping("/book/{id}")
    public ResponseEntity<String> editBook(@PathVariable("id") int id,@RequestBody Book bo){
        boolean exist=bookRepo.existsById(id);
        if (exist) {
            Book book=bookRepo.findById(id).get();
            book.setName(bo.getName());
            book.setPrice(bo.getPrice());
            String categoryName = bo.getCategoryId().getCateName();
            Category category=categoryRepo.findByCateName(categoryName);
            book.setCategoryId(category);
            bookRepo.save(book);
            return new ResponseEntity<>("Book updated", HttpStatus.OK);
        }
        return new ResponseEntity<>("Book don't exist",HttpStatus.BAD_REQUEST);
    }

//    @DeleteMapping("/book/{id}")
//    public ResponseEntity<String> deleteBook(@PathVariable("id")int id){
//        boolean exist=bookRepo.existsById(id);
//        if (exist){
//            bookRepo.deleteById(id);
//            return new ResponseEntity<>("Book Deleted",HttpStatus.OK);
//        }
//        return new ResponseEntity<>("Book not deleted",HttpStatus.BAD_REQUEST);
//    }
    @DeleteMapping("/book/{id}")
    public void deleteBook(@PathVariable("id")int id){
        boolean exist=bookRepo.existsById(id);
        if (exist){
            bookRepo.deleteById(id);

        }
    }



// Category Rest Controller Method
@GetMapping("/cate")
    public List<Category> getCat(){
        return categoryRepo.findAll();
}


    @PostMapping("/cate")
    public Category saveCate(@RequestBody Category category){
        return categoryRepo.save(category);
    }

    @PutMapping("/cate/{id}")
    public ResponseEntity<String> editCate(@PathVariable("id")int id,@RequestBody Category cate){
        boolean exist=categoryRepo.existsById(id);
        if (exist){
            Category category=categoryRepo.findById(id).get();
            category.setCateName(cate.getCateName());
            return new ResponseEntity<>("Category updated",HttpStatus.OK);
        }
        return new ResponseEntity<>("Category don't exist",HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/cate/{id}")
    public ResponseEntity<String> deleteCate(@PathVariable("id")int id){
        boolean exist=categoryRepo.existsById(id);
        if (exist){
            categoryRepo.deleteById(id);
            return new ResponseEntity<>("Category Deleted",HttpStatus.OK);
        }
        return new ResponseEntity<>("Category don't exist,not deleted",HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/product/display")


    @PostMapping(value = "/product",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<ProductImage> addNewProduct(@RequestPart ("product") ProductImage product,
                                                      @RequestPart("imageFile") MultipartFile file) throws IOException {
        //save image
     if(!file.isEmpty()){
         byte[] bytes=file.getBytes();
         String originalFileName = file.getOriginalFilename();
         //timestamp for unique image name
         Long timestamp=System.currentTimeMillis();
         //file extension
         if (originalFileName == null) throw new AssertionError();
         String fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
         //new file name
         String newFileName = "product_"+timestamp+fileExtension;
         //set file name to database
         product.setProductImage(newFileName);
         //save image with new name in specific directory
         String uploadDirectory = "src/main/resources/static/assets/image/products_image/";
         Path uploadPath= Path.of(uploadDirectory);
         if (!Files.exists(uploadPath)){
             Files.createDirectories(uploadPath);
         }
         Path filePath = uploadPath.resolve(newFileName);
         Files.write(filePath,bytes);
     }
     productImageRepo.save(product);
     return ResponseEntity.ok(product);

    }




}
