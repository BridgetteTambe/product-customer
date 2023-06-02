package com.bree.com.resources;

import com.bree.com.models.Address;
import com.bree.com.models.Order;
import com.bree.com.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Order saveOrders(@RequestBody Order order)throws Exception{
        LOGGER.info("Rest request to save order data:{}",order);
        if(order.getId() != null){
            throw new Exception("Cant save order with id");
        }
        return orderService.save(order);
    }
    @PutMapping("/order")
    public Order updateAddress(@RequestBody Order order)throws Exception{
        LOGGER.info("Rest request to update order :{}",order);
        if(order.getId() == null){
            throw new Exception("Cant update order with a null id:{}");
        }
        return orderService.save(order);

    }
    @GetMapping("/order/{id}")
    public Order getAddressById(@PathVariable Long id){
        LOGGER.info("Rest request to get order  by id:{}",id);
        return orderService.findById(id);
    }

    @GetMapping("/order")
    List<Order> findAll() {
        LOGGER.info("Rest request to get all order:");
        return orderService.findAll();
    }

    @DeleteMapping("/order/{id}")
    public void deleteById(@PathVariable Long id){
        LOGGER.info("Rest request to delete order by id:{}", id);
        orderService.deleteById(id);
    }

    @DeleteMapping("/order")
    public void deleteAll(){
        LOGGER.info("Rest request to delete order:");
        orderService.deleteAll();
    }

}
