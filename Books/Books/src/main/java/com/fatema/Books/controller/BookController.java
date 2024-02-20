package com.fatema.Books.controller;

import com.fatema.Books.model.Book;
import com.fatema.Books.repository.IBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
import java.util.Optional;

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

    @GetMapping("/book/display")
    public ResponseEntity<byte[]> getBookImage(@RequestParam("id") int id) throws IOException{

        Optional<Book> book=iBook.findById(id);
        if (book.isPresent()){
            Book bookImage=book.get();
            //select directory
            String uploadDirectory="";
            String fileName=bookImage.getImagePath();
            String filePath=Path.of(uploadDirectory,fileName).toString();
            try {
                Path path=Path.of(filePath);
                byte[] imageByte=Files.readAllBytes(path);
                return ResponseEntity
                        .ok()
                        .contentType(MediaType.IMAGE_JPEG)
                        .header(HttpHeaders.CONTENT_DISPOSITION,"inline+filename="
                                +path.getFileName().toString())
                        .body(imageByte);
            } catch (IOException e){
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            }

        }
        return ResponseEntity.notFound().build();
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
