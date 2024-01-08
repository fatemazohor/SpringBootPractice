package com.fatema.LearningManagementSys.controller;

import com.fatema.LearningManagementSys.model.Role;
import com.fatema.LearningManagementSys.model.User;
import com.fatema.LearningManagementSys.repository.IRoleRepository;
import com.fatema.LearningManagementSys.repository.IUserRepository;
import com.fatema.LearningManagementSys.service.UserService;
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
    private IRoleRepository roleRepo;

    @Autowired
    private IUserRepository userRepo;

    @GetMapping("")
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
