package com.example.testSpring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

    @RequestMapping("")
    public String getHome(){
        return "index";
    }

    @RequestMapping("/page")
    public String getPage(){
        return "page";
    }

}
