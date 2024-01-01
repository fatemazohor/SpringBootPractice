package com.example.ProjectSecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/student")
public class StudentController {

    @GetMapping("/entryform")
    public String enttyForm(){
        return "student";
    }


    @GetMapping("/save")
    public String saveForm(){
        return "viewstudent";
    }
}
