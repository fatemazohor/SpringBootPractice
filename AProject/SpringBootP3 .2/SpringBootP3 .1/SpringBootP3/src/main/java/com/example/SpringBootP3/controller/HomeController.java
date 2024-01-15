package com.example.SpringBootP3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    private String home(){
        return "index";
    }
    @GetMapping("/page")
    private String page(){
        return "page";
    }
    @GetMapping("/page2")
    private String page2(){
        return "page2";
    }
    @GetMapping("/techpage")
    private String techpage(){
        return "other/techpage";
    }
}
