package com.example.SpringBootSecurity66.controller;

import com.example.SpringBootSecurity66.model.Role;
import com.example.SpringBootSecurity66.model.Token;
import com.example.SpringBootSecurity66.model.User;
import com.example.SpringBootSecurity66.repository.IRoleRepo;
import com.example.SpringBootSecurity66.repository.ITokenRepo;
import com.example.SpringBootSecurity66.repository.IUserRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class UserController {



    @Autowired
    IUserRepository userRepo;
    @Autowired
    IRoleRepo roleRepo;

    @Autowired
    ITokenRepo tokenRepo;


    @Autowired
    JavaMailSender javaMailSender;

     long startTime;


    @GetMapping("admin/user/all")
    public String allUser(Model m){
        List<User> userList=userRepo.findAll();
        m.addAttribute("userList", userList);
        return "alluser";

    }

    @RequestMapping("public/user/saveform")
    public String userSaveForm(Model m){
        m.addAttribute("user", new User());
        return  "saveuserform";
    }

    @PostMapping("public/user/save")
    public String save(@ModelAttribute User user) throws MessagingException {

        long s=System.currentTimeMillis();
         startTime =s+200000l;

        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        Role userRole=new Role(1);
        user.addRole(userRole);
        userRepo.save(user);

        Token token=new Token(user);
        tokenRepo.save(token);

        MimeMessage mimeMessage= javaMailSender.createMimeMessage();
        MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
        message.setTo(user.getEmail());

        String html = "<!doctype html>\n" +
                "<html lang=\"en\" xmlns=\"http://www.w3.org/1999/xhtml\"\n" +
                "      xmlns:th=\"http://www.thymeleaf.org\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\"\n" +
                "          content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" +
                "    <title>Email</title>\n" +
                "</head>\n" +
                "<body>\n" +
//                   "Dear " + ccm.getCcCompanyName() + "\n" + "To confirm your account, please click here :" +

                "<div>Welcome <b>" + user.getName() + "</b></div>\n" +
                "\n" +
                "<div>Your Token is  <b>  </b></div>\n" +
                "<div>Plaese Click Here <b> "+ "http://localhost:8088/public/confirm-account?token="+ token.getConfirmationToken() +" </b></div>\n" +
                "<div> Your username is <b>" + " " + "</b></div>\n" +
                "<div> Any Information Please Call <b>" + " 123456789 " + "</b></div>\n" +
                "</body>\n" +
                "</html>\n";

        message.setSubject("Confirm Registration");
        message.setFrom("info@emranhss.com");

        message.setText(html, true);
        javaMailSender.send(mimeMessage);

        return "redirect:/";
    }


    @RequestMapping(value = "/public/confirm-account", method = {RequestMethod.GET, RequestMethod.POST})
    public String confirmCorporatUser(@RequestParam("token") String token, Model m) {
        Token confirmationToken = tokenRepo.findByConfirmationToken(token);
        if(token != null){
            long endTime=System.currentTimeMillis();
            System.out.println("Start "+startTime);
            System.out.println("End "+endTime);
            if (startTime>endTime){
               User user= userRepo.findByEmail(confirmationToken.getUser().getEmail());
                System.out.println("+++++++++++++++++++");
               user.setEnable(true);
                System.out.println("--------------------");

               userRepo.save(user);
               m.addAttribute("message","Account Verified" );
            }else{
                System.out.println("Time-----------Out");
            }
        } else {
            m.addAttribute("message", "The link is invalid or broken!");
        }
        return "redirect:/";
    }


}
