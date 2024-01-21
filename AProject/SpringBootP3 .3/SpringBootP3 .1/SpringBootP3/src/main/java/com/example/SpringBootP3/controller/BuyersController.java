package com.example.SpringBootP3.controller;

import com.example.SpringBootP3.model.buyer.Buyers;
import com.example.SpringBootP3.model.buyer.OrderDetails;
import com.example.SpringBootP3.model.buyer.OrderStatus;
import com.example.SpringBootP3.model.sale.Size;
import com.example.SpringBootP3.repository.buyer.IBuyerRepo;
import com.example.SpringBootP3.repository.buyer.IOrderDetails;
import com.example.SpringBootP3.repository.buyer.IOrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BuyersController {
    @Autowired
    private IBuyerRepo buyerRepo;
    @Autowired
    private IOrderStatus orderStatusRepo;
    @Autowired
    private IOrderDetails orderDetailsRepo;

    //buyers registration
    @GetMapping("/buyers/list")
    public String buyersList(Model m){
        List<Buyers> buyersList=buyerRepo.findAll();
        m.addAttribute("title","Buyers List");
        m.addAttribute("buyersList", buyersList);
        return "buyers/buyersList";
    }
    @GetMapping("/buyers/addform")
    public String buyersform(Model m){


        m.addAttribute("buyers",new Buyers());
        m.addAttribute("title","Create new Buyers");
        return "buyers/buyersForm";
    }

    @PostMapping("/buyers/save")
    public String buyersSave(@ModelAttribute Buyers buyers){
        buyerRepo.save(buyers);
        return "redirect:/buyers/list";
    }
    @GetMapping("/buyers/delete/{id}")
    public String buyersDelete(@PathVariable int id){
        buyerRepo.deleteById(id);
        return "redirect:/buyers/list";
    }

    @GetMapping("/buyers_edit/{id}")
    public String buyersEdit(@PathVariable int id,Model m){
        Buyers buyersname=buyerRepo.findById(id).get();
        m.addAttribute("title","Update Buyers");
        m.addAttribute("buyers",buyersname);
        return "buyers/buyersForm";

    }
    //buyers registration end
    //Order Status start
    @GetMapping("/order_status/list")
    public String orderStatusList(Model m){
        List<OrderStatus> orderStatusList=orderStatusRepo.findAll();
        m.addAttribute("title","Order Status List");
        m.addAttribute("orderStatusList", orderStatusList);
        return "buyers/orderStatusList";
    }
    @GetMapping("/order_status/addform")
    public String orderStatusform(Model m){


        m.addAttribute("orderStatus",new OrderStatus());
        m.addAttribute("title","Create new Order Status");
        return "buyers/orderStatusForm";
    }

    @PostMapping("/order_status/save")
    public String orderStatusSave(@ModelAttribute OrderStatus orderStatus){
        orderStatusRepo.save(orderStatus);
        return "redirect:/order_status/list";
    }
    @GetMapping("/order_status/delete/{id}")
    public String orderStatusDelete(@PathVariable int id){
        orderStatusRepo.deleteById(id);
        return "redirect:/order_status/list";
    }

    @GetMapping("/order_status_edit/{id}")
    public String orderStatusEdit(@PathVariable int id,Model m){
        OrderStatus orderStatusname=orderStatusRepo.findById(id).get();
        m.addAttribute("title","Update Order Status");
        m.addAttribute("orderStatus",orderStatusname);
        return "buyers/orderStatusForm";

    }
    //Order Status end
    //Order Details

    @GetMapping("/order_details/list")
    public String orderdetailsList(Model m){
        List<OrderDetails> orderDetailsList=orderDetailsRepo.findAll();
        m.addAttribute("title","Order Details List");
        m.addAttribute("orderDetailsList", orderDetailsList);
        return "buyers/orderDetailsList";
    }
    @GetMapping("/order_details/addform")
    public String orderDetailsform(Model m){


        m.addAttribute("orderDetails",new OrderDetails());
        m.addAttribute("title","Create new Order Details");
        return "buyers/orderDetailsForm";
    }

    @PostMapping("/order_details/save")
    public String orderDetailsSave(@ModelAttribute OrderDetails orderDetails){
        orderDetailsRepo.save(orderDetails);
        return "redirect:/order_details/list";
    }
    @GetMapping("/order_details/delete/{id}")
    public String orderDetailsDelete(@PathVariable int id){
        orderDetailsRepo.deleteById(id);
        return "redirect:/order_details/list";
    }

    @GetMapping("/order_details_edit/{id}")
    public String orderDetailsEdit(@PathVariable int id,Model m){
        OrderDetails orderDetailsname=orderDetailsRepo.findById(id).get();
        m.addAttribute("title","Update Order Details");
        m.addAttribute("orderDetails",orderDetailsname);
        return "buyers/orderDetailsForm";

    }



    //Order Details end
}
