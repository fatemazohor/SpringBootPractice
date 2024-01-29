package com.example.EmailSend.controller;

import com.example.EmailSend.model.User;
import com.example.EmailSend.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @Autowired
    IUserRepository userRepository;

    @GetMapping("/")
    public String index(){

        return "index";
    }
     @GetMapping("/login")
    public String login(){

        return "login";
    }
     @GetMapping("/registration")
    public String register(Model model){
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/createuser")
    public String createUser(@ModelAttribute User user, Model model){
        User newUser=userRepository.save(user);
        if (newUser!=null){

            model.addAttribute("message","Registration Successfull");
        }

        else {
            model.addAttribute("message","Registration not Successfull");
        }
        return "redirect:/registration";
    }


}
