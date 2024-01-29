package com.example.EmailSend.controller;

import com.example.EmailSend.model.Department;
import com.example.EmailSend.repository.IDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class DepartmentController {
//
//    @Autowired
//    private IDepartmentRepository department;
//    @Autowired
//    private IDepartmentRepository departmentRepository;
//
//    @RequestMapping("/department")
//    public  String form(){
//        return "dForm";
//    }
//    public  String allDepartment(Model model){
//
//        List<Department> departmentList=departmentRepository.findAll();
//        model.addAttribute("departmrntList",departmentList);
//        model.addAttribute("department",new Department());
//        return "department";
//    }
//
//    @PostMapping("/save")
//    public String saveForm(@ModelAttribute Department department){
//
//        departmentRepository.save(department);
//
//        return "redirect:/department";
//    }
//

}
