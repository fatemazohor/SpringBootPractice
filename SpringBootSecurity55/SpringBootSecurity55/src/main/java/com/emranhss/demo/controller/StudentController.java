package com.emranhss.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/student")
public class StudentController {

    @GetMapping("/saveform")
    public String studentForm(){

        return "student";
    }

    @GetMapping("/all")
    public String all(){

        return "viewallstudent";
    }





}
