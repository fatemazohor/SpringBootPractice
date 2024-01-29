package com.fatema.Books.restController;

import com.fatema.Books.model.Book;
import com.fatema.Books.model.Category;
import com.fatema.Books.repository.IBook;
import com.fatema.Books.repository.ICategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class BookRestController {

    @Autowired
    private IBook bookRepo;

    @Autowired
    private ICategory categoryRepo;


//    swagger link: http://localhost:8086/swagger-ui/index.html#/


    @GetMapping("/book")
    public List<Book> getBook(){
        return bookRepo.findAll();
    }

    @PostMapping("/book")
    public Book savebook(@RequestBody Book book){
        
        return bookRepo.save(book);
    }

    @PutMapping("/book/{id}")
    public ResponseEntity<String> editBook(@PathVariable("id") int id,@RequestBody Book bo){
        boolean exist=bookRepo.existsById(id);
        if (exist) {
            Book book=bookRepo.findById(id).get();
            book.setName(bo.getName());
            book.setPrice(bo.getPrice());
            bookRepo.save(book);
            return new ResponseEntity<>("Book updated", HttpStatus.OK);
        }
        return new ResponseEntity<>("Book don't exist",HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable("id")int id){
        boolean exist=bookRepo.existsById(id);
        if (exist){
            bookRepo.deleteById(id);
            return new ResponseEntity<>("Book Deleted",HttpStatus.OK);
        }
        return new ResponseEntity<>("Book not deleted",HttpStatus.BAD_REQUEST);
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






}
