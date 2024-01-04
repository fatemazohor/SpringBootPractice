package com.example.testSpring.controller;

import com.example.testSpring.model.Role;
import com.example.testSpring.model.User;
import com.example.testSpring.repository.IRoleRepo;
import com.example.testSpring.repository.IUserRepo;
import com.example.testSpring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private IRoleRepo roleRepo;
    @Autowired
    private IUserRepo userRepo;

    @GetMapping("")
    public String getAlluser(Model m){
        List<User> userslist=userRepo.findAll();
        m.addAttribute("userlist",userslist);
        return "userlist";
    }

    @RequestMapping("/userform")
    public String addUser(Model m){
        List<Role> roleList = roleRepo.findAll();
        m.addAttribute("role", new Role());

        m.addAttribute("rolelist",roleList);
        m.addAttribute("adduser", new User());
        return "userform";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute User user){

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return "redirect:/user";
    }

}
