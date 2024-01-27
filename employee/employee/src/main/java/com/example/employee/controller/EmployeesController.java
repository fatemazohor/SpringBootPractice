package com.example.employee.controller;


import com.example.employee.model.Employees;
import com.example.employee.model.Role;
import com.example.employee.repository.Iemployee;
import com.example.employee.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller

public class EmployeesController {
    @Autowired
    private Iemployee iemployeeRepo;


    //emp list
    @GetMapping("/employees")
    public String getEmp(Model m){
        List<Employees> employeesList = iemployeeRepo.findAll();
        m.addAttribute("empList", employeesList);
        m.addAttribute("title", "Employees List");

        m.addAttribute("employee", new Employees());
        return "EmployeeList";
    }

    @GetMapping("/public/add")
    public String addEmp(Model m){
        m.addAttribute("employee", new Employees());
        m.addAttribute("title", "Employee Form");
        return "FormEmployees";
    }

    @PostMapping("/public/save")
    public String saveEmP(@ModelAttribute Employees e){

        Role userRole = new Role(1);
        e.addRole(userRole);

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        e.setPassword(encoder.encode(e.getPassword()));
        iemployeeRepo.save(e);
        return "redirect:/employees";

    }

    @GetMapping("/employees/delete/{id}")
    public String deleteEmp(@PathVariable int id){
        iemployeeRepo.deleteById(id);
        return "redirect:/employees";
    }

    @GetMapping("/update/{id}")
    public String updateEmp(@PathVariable int id,Model m){
        Employees emp= iemployeeRepo.findById(id).get();
        m.addAttribute("employee", emp);
        return "FormEmployees";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout){
        if (error != null) {
            model.addAttribute("error", "Your username and password are invalid.");
        }

        if (logout != null) {
            model.addAttribute("message", "Logged out successfully.");
        }
         return "auth-login-basic";
    }

    @PostMapping("/login")
    public String login(@RequestParam("email") String email, @RequestParam("password") String password) {
        // Your login logic here
        return "redirect:/employees"; // Redirect to a dashboard page after successful login
    }

    @GetMapping("/logout")
    public String logout(){
         return "auth-register-basic";
    }




}
