package com.example.products.Controller;

import com.example.products.Model.Orders;
import com.example.products.Repository.IOrderDetails;
import com.example.products.Services.OrdersService;
import com.fasterxml.jackson.core.io.JsonEOFException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class OrderController {

    @Autowired
    private OrdersService ordersService;
    @Autowired
    private IOrderDetails orderDetailsRepo;

    @GetMapping("/order")
    public String orderForm() {

        return "orderForm";
    }



    @PostMapping("/save")

    public @ResponseBody String saveOrders(
            @RequestParam("styleId") String style,
            @RequestParam("buyerId") String buyer,
            @RequestParam("qty") String qty
//            @RequestParam("price") String price

//            @RequestParam("orderDate") String orderDate,
//            @RequestParam("deliveryDate") String deliveryDate


    ) throws JsonEOFException {
        System.out.println("inside order controller");
        Orders orders=ordersService.orderDataSave(style,buyer,qty);
//
//        Orders orders = ordersService.orderDataSave(style, buyer);

//        JSONPObject resobj;
//        resobj = new JSONPObject("id", orders.getStyleId());


        return "Data saved";
    }

//    @GetMapping("/orderdetails")
//    public String orderDetForm() {
//
//        return "orderDetailsForm";
//    }
//    @PostMapping("/det_save")
//    public String orDetailssave(@ModelAttribute("ordere")Orders orders){
//    ordersService.saveData(orders);
//        return "data saved";
//    }
//
//    @PostMapping("/details_save")
//    public String  detailsSave(
//            @RequestParam("sizeId")String sizeId,
//            @RequestParam("quantity")String quantity,
//            @RequestParam("price")String price,
//            @RequestParam("total")String total
//    ){
//
//        return "details";
//    }




//    @PostMapping("/order_save")
//    public String newOrderSave(@ModelAttribute("orders")Orders orders){
//        System.out.println("3rd time");
//        ordersService.saveData(orders);
//        return "orderForm";
//    }

//    @PostMapping("/order/save")
//    public ResponseEntity<String> getOrderSave(@RequestBody Orders orders){
//        try {
//            Orders or=new Orders();
//            or.setStyleId(orders.getStyleId());
//            or.setBuyerId(orders.getBuyerId());
//            or.setOrderDate(orders.getOrderDate());
//            or.setDeliveryDate(orders.getDeliveryDate());
//
//            ordersService.saveData(or);
//
//            return new ResponseEntity<>("Order sucess", HttpStatus.OK);
//
//        }catch (Exception e){
//            System.out.println(e);
//            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
//
//
//        }
//
//
//    }

}
