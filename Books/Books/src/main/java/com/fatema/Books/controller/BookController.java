package com.fatema.Books.controller;

import com.fatema.Books.model.Book;
import com.fatema.Books.repository.IBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BookController {


    @Autowired
    private IBook iBook;
    @GetMapping("/home")
    public String home(Model m){
        List<Book> bookList =iBook.findAll();
        m.addAttribute("bookList",bookList);

        return "home";
    }

}
