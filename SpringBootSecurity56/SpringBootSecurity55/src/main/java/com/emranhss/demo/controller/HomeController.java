package com.emranhss.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/public/")
public class HomeController {

    @GetMapping("")
    public String home(){

        return "home";
    }

    @GetMapping("page")
    public String publicPage(){

        return "public";
    }




}
