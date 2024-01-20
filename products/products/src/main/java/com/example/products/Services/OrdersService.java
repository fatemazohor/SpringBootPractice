package com.example.products.Services;

import com.example.products.Model.Orders;
import com.example.products.Repository.IOrders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;

@Service
public class OrdersService {
    @Autowired
    private IOrders ordersRepo;

    public Orders orderDataSave(String style, String buyer){

        Orders orders=new Orders();
        orders.setStyleId(style);
        orders.setBuyerId(buyer);
//        orders.setOrderDate(orderDate);
//        orders.setDeliveryDate(deliveryDate);
        ordersRepo.save(orders);

        return orders;
    }
//3rd method
    public void saveData(Orders orders){
         ordersRepo.save(orders);

    }
}
