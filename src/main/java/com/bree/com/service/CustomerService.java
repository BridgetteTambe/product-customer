package com.bree.com.service;

import com.bree.com.models.Address;

import com.bree.com.models.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CustomerService {

    Customer save(Customer customer);

    List<Customer> saveAll(List<Customer>  customers);


    Customer update(Customer customer);

    void deleteAll();

    void deleteById(Long id);

    Customer findById(Long id);

    List<Customer> findAll();


}
