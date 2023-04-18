package com.bree.com.service;

import com.bree.com.models.Address;
import com.bree.com.models.Cart;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CartService {

    public Cart save(Cart cart);

    public List<Cart> saveAll(List<Cart> cart);

    public Cart updateAddress(Cart cart);

    public Cart findById(Long id);

    List<Cart>findAll();

    public void deleteById(Long id);

    public void deleteAll();
}
