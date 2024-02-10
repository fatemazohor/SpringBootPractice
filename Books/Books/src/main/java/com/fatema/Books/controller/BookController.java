package com.fatema.Books.controller;

import com.fatema.Books.model.Book;
import com.fatema.Books.repository.IBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLException;
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

    @GetMapping("/entry")
    public String bookForm(Model m){
        m.addAttribute("book",new Book());

        return "entry";
    }
    @PostMapping("/entry/save")
    public String bookSave(@ModelAttribute @Validated Book book,
                           BindingResult result, @RequestParam("imagePath")MultipartFile image)
    throws IOException, SQLException {
        //save image start

        if(!image.isEmpty()){
            byte[] bytes=image.getBytes();
            String originalFileName=image.getOriginalFilename();
            //timestamp
            Long timestamp=System.currentTimeMillis();
            //file extension
            String fileExtension=originalFileName.substring(originalFileName.lastIndexOf("."));
            //new file name
            String newFileName="book_"+timestamp+fileExtension;
            //set file name to databse
            book.setImagePath(newFileName);
            //save image with new name in specific directory
            String uploadDirectory="";
            Path uploadPath= Path.of(uploadDirectory);
            if (!Files.exists(uploadPath)){
                Files.createDirectories(uploadPath);
            }
            Path filePath=uploadPath.resolve(newFileName);
            Files.write(filePath,bytes);
        }
        //save image end
        iBook.save(book);
        return "home";
    }

}
