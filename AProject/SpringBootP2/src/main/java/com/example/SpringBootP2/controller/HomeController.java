package com.example.SpringBootP2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String home(){
        return "index";
    }

    @GetMapping("/page")
    public String page(){
        return "page";
    }

    @GetMapping("/page2")
    public String pages(){
        return "page2";
    }
}
