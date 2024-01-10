package com.example.testSecuritySpring.Controller;

import com.example.testSecuritySpring.model.Role;
import com.example.testSecuritySpring.model.User;
import com.example.testSecuritySpring.repository.IRoleRepo;
import com.example.testSecuritySpring.repository.IUserRepo;
import com.example.testSecuritySpring.service.UserService;
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

public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private IRoleRepo roleRepo;

    @Autowired
    private IUserRepo userRepo;

    @GetMapping("/user")
    private String getAlluser(Model m){
        List<User> userList=userRepo.findAll();
        m.addAttribute("userList",userList);
        return "userlist";
    }

    @RequestMapping("/userform")
    private String saveForm(Model m){
        List<Role> roleList =roleRepo.findAll();

        m.addAttribute("roleList", roleList);
        m.addAttribute("role", new Role());

        m.addAttribute("user",new User());
        return "userform";
    }

    @PostMapping("/save")
    private String saveuser(@ModelAttribute User user){

        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
//        Role userRole=new Role(1);
//        user.addRole(userRole);
        userRepo.save(user);

        return "redirect:/user";
    }
}
