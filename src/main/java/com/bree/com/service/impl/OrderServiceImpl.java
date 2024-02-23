package com.bree.com.service.impl;


import com.bree.com.models.Order;
import com.bree.com.models.Product;
import com.bree.com.repository.OrderRepository;
import com.bree.com.service.OrderService;
import com.bree.com.service.ProductService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;


import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public Order placeOrder(Order order) {


        return orderRepository.save(order);
    }


    @Override
    public Order approveOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order cancelOrder(Order order) throws Exception {
        return orderRepository.save(order);
    }

    @Override
    public Page<Order> findAll(Pageable pageable) {
        return orderRepository.findAll(pageable);
    }

}