package com.emranhss.demo.controller;

import com.emranhss.demo.model.Role;
import com.emranhss.demo.model.User;
import com.emranhss.demo.repository.IRoleRepo;
import com.emranhss.demo.repository.IUserRepo;
import com.emranhss.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String viewAllUser(Model m){
       List<User> userList= userRepo.findAll();
        m.addAttribute("userList", userList);

        return "alluser";
    }

    @RequestMapping("/saveform")
    public String userSaveForm(Model m){
        m.addAttribute("user", new User());
        return  "saveuserform";
    }

    @PostMapping(value = "/save")
    public  String userSave(@ModelAttribute User user){

        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        Role userRole=new Role(1);
        user.addRole(userRole);
        userRepo.save(user);
        return "redirect:/user";
    }



}
