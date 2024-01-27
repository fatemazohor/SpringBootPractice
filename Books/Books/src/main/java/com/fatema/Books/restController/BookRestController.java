package com.fatema.Books.restController;

import com.fatema.Books.model.Book;
import com.fatema.Books.repository.IBook;
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





}
