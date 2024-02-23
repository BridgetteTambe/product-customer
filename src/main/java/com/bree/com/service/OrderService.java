package com.bree.com.service;

import com.bree.com.models.Customer;
import com.bree.com.models.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


public interface OrderService {

        Order placeOrder(Order order);

        Order approveOrder(Order order) throws Exception;

        Order cancelOrder(Order order) throws Exception;

        Page<Order> findAll(Pageable pageable) ;


//        List<Order> saveAll(List<Order>  order);
//
//
////        Order update(Order order);
//
//        void deleteAll();
//
//        void deleteById(Long id);
//
//        Order findById(Long id);
//
//        List<Order> findAll();







}
