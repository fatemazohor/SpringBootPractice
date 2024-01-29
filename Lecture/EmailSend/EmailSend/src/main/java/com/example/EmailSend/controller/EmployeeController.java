package com.example.EmailSend.controller;

import com.example.EmailSend.model.Employee;
import com.example.EmailSend.repository.IEmployeeRepository;
import jakarta.persistence.Lob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private IEmployeeRepository employeeRepository;


    @GetMapping("/all")
    public  String allEmployee(Model model){

        List<Employee>  employeeList=employeeRepository.findAll();
        model.addAttribute("employeeList",employeeList);
        model.addAttribute("employee",new Employee());
        return "employee/allemployee";
    }


//    @GetMapping("/save")
//    public String showForm(Model model){
//        model.addAttribute("employee", new Employee());
//        return "employee/allemployee";
//    }

    @PostMapping("/save")
    public String saveForm(@ModelAttribute Employee employee){

        employeeRepository.save(employee);

        return "redirect:/employee/all";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id){
        employeeRepository.deleteById(id);
        return "redirect:/employee/all";
    }

     @RequestMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model){
        Employee employee=employeeRepository.findById(id).get();
         System.out.println(employee);
        model.addAttribute("employee",employee);
        return "employee/allemployee";
    }


}
