package com.example.products.Services;

import com.example.products.Model.OrderDetails;
import com.example.products.Model.Orders;
import com.example.products.Repository.IOrderDetails;
import com.example.products.Repository.IOrders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersService {
    @Autowired
    private IOrders ordersRepo;
    @Autowired
    private IOrderDetails iOrderDetailsnrepo;

    public Orders orderDataSave(String style, String buyer,String qty){

//        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        LocalDateTime myDate = LocalDateTime.parse(deliveryDate,formatter);

        //price string to double
//        Double myPrice=Double.valueOf(price);
//        double mypr=Double.parseDouble(price);

        Orders orders=new Orders();
        orders.setStyleId(style);
        orders.setBuyerId(buyer);
        orders.setQty(qty);
//        orders.setPrice(mypr);
//        orders.setOrderDate();
//        orders.setDeliveryDate(myDate);
        ordersRepo.save(orders);

        return orders;
    }
//3rd method
    public void saveData(Orders od){
         ordersRepo.save(od);

    }

    public void saveDetails(String sizeId, String quantity,String price
    ,String total){
        OrderDetails myDetails = new OrderDetails();
        myDetails.setSizeId(sizeId);
        myDetails.setQuantity(quantity);
        myDetails.setPrice(price);
        myDetails.setTotal(total);
        iOrderDetailsnrepo.save(myDetails);
    }
}
