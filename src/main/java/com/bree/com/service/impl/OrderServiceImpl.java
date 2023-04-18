package com.bree.com.service.impl;


import com.bree.com.models.Order;
import com.bree.com.repository.OrderRepository;
import com.bree.com.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;
    @Override
    public Order save(Order order) {
        return  orderRepository.save(order);
    }

    @Override
    public List<Order> saveAll(List<Order> order) {
        return orderRepository.saveAll(order);
    }

    @Override
    public Order update(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public void deleteAll() {
orderRepository.deleteAll();
    }

    @Override
    public void deleteById(Long id) {
orderRepository.deleteById(id);
    }

    @Override
    public Order findById(Long id) {
        Optional<Order>findById= orderRepository.findById(id);

        return findById.orElse(null);
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }
}
