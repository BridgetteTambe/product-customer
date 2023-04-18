package com.bree.com.service;

import com.bree.com.models.Customer;
import com.bree.com.models.Order;
import org.springframework.stereotype.Service;

import java.util.List;


public interface OrderService {

        Order save(Order order);

        List<Order> saveAll(List<Order>  order);


        Order update(Order order);

        void deleteAll();

        void deleteById(Long id);

        Order findById(Long id);

        List<Order> findAll();



}
