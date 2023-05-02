package com.bree.com.service.impl;

import com.bree.com.models.Customer;
import com.bree.com.repository.CustomerRepository;
import com.bree.com.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;
    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> saveAll(List<Customer> customers) {
        return customerRepository.saveAll(customers);
    }

    @Override
    public Customer update(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void deleteById(Long id) {
customerRepository.deleteById(id);
    }

    @Override
    public Customer findById(Long id) {
        Optional<Customer>findById = customerRepository.findById(id);
        return findById.orElse(null) ;
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer login(String email, String password) {
        return customerRepository.findByEmailAndPassword(email,password);
    }
}
