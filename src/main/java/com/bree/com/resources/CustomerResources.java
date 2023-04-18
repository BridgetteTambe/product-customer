package com.bree.com.resources;

import com.bree.com.models.Customer;
import com.bree.com.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200/")
public class CustomerResources {

    private Logger LOGGER = LoggerFactory.getLogger(CustomerResources.class);
    @Autowired
   private CustomerService customerService;

    @PostMapping("/customer")
    public Customer saveCustomer(@RequestBody Customer customer) throws Exception {
        LOGGER.info("Rest request to save customer details");
        if (customer.getId() != null) {
            throw new Exception("Cant save student with this id:{}");
        }
        return customerService.save(customer);
    }

    @PutMapping("/customer")
    public Customer updateCustomer(@RequestBody Customer customer) throws Exception {
        LOGGER.info("Rest request to update customer:{}", customer);
        if (customer.getId() == null) {
            throw new Exception("Cant update customer with id: {}");
        }
        return customerService.save(customer);
    }

    @GetMapping("/customer/{id}")
    public Customer findById(@PathVariable Long id) {
        LOGGER.info("Rest request to get customer by id:{}");
        return customerService.findById(id);
    }

    @GetMapping("/customer")
    List<Customer> findAll() {
        LOGGER.info("Rest request to get all customers:{}");
        return customerService.findAll();
    }

    @DeleteMapping("/customer")
    public String deleteAllCustomer(@RequestBody Customer customer) {
        LOGGER.info("Rest request to delete customer:{}");
        customerService.deleteAll();
        return "Customer with id";
    }

    @DeleteMapping("/customer/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        LOGGER.info("Rest request to delete customer:{}");
        customerService.deleteById(id);
        return "Customer with id" + id + "Customer deleted";
    }

}
