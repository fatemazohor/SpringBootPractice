package com.example.products.Controller;

import com.example.products.Repository.IBuyerOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.nio.ByteOrder;

@Controller
public class BuyerOrder {
    @Autowired
    private IBuyerOrder buyerOrderrepo;

//    @GetMapping("/buyer_page")
//    private String getBuyer(Model m){
//
//        m.addAttribute("buyerd",new BuyerOrder());
//        return "buyerpage";
//
//    }
//
//    @PostMapping("/save")
//    private String getsaveBuyer(@ModelAttribute BuyerOrder buyerd){
////    buyerOrderrepo.save(buyerd);
//
//        return "buyerpage";
//
//    }
}
