package com.bree.com.resources;

import com.bree.com.models.Address;
import com.bree.com.models.Order;
import com.bree.com.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:4200/", "http://localhost:4200","http://localhost:4201","https://product-admin-view.vercel.app/","https://product-customer-view.vercel.app/"})
public class OrderResource {

    @Autowired
    OrderService orderService;
    private Logger LOGGER = LoggerFactory.getLogger(OrderResource.class);

    @PostMapping("/order")
    public Order placeOrder(@RequestBody Order order)throws Exception{
        LOGGER.info("Rest request to save order data:{}",order);
        if(order.getId() != null){
            throw new Exception("Cant save order with id");
        }
        return orderService.placeOrder(order);
    }
    @PutMapping("/order")
    public Order approveOrder(@RequestBody Order order)throws Exception{
        LOGGER.info("Rest request to update order :{}",order);
        if(order.getId() == null){
            throw new Exception("Cant update order with a null id:{}");
        }
        return orderService.approveOrder(order);

    }

    @GetMapping("/order")
    Page<Order> findAll(Pageable pageable) {
        LOGGER.info("Rest request to get all order:");
        return orderService.findAll(pageable);
    }


    @DeleteMapping("/order")
    public void cancelOrder(@RequestBody Order order) throws Exception {
        LOGGER.info("Rest request to delete order:");
        orderService.cancelOrder(order);
    }
//    @GetMapping("/order/{id}")
//    public Order getOrderById(@PathVariable Long id){
//        LOGGER.info("Rest request to get order  by id:{}",id);
//        return orderService.findById(id);
//    }



}
