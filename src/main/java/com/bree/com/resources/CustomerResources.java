package com.bree.com.resources;

import com.bree.com.models.Customer;
import com.bree.com.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:4200/", "http://localhost:4200","http://localhost:4201","https://product-admin-view.vercel.app/","https://product-customer-view.vercel.app/"})
public class CustomerResources {

    private Logger LOGGER = LoggerFactory.getLogger(CustomerResources.class);
    @Autowired
    private CustomerService customerService;

    @PostMapping("/customer")
    public Customer saveCustomer(@RequestBody Customer customer) throws Exception {
        LOGGER.info("Rest request to save customer details : {}", customer);
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
        LOGGER.info("Rest request to get customer by id:{}", id);
        return customerService.findById(id);
    }

    @GetMapping("/customer")
    List<Customer> findAll() {
        LOGGER.info("Rest request to get all customers:");
        return customerService.findAll();
    }

    @DeleteMapping("/customer")
    public String deleteAllCustomer() {
        LOGGER.info("Rest request to delete all customer:");
        customerService.deleteAll();
        return "Customer with id";
    }

    @DeleteMapping("/customer/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        LOGGER.info("Rest request to delete customer:{}", id);
        customerService.deleteById(id);
        return "Customer with id" + id + "Customer deleted";
    }

    @GetMapping("/customer/login/{email}/{password}")
    public Customer getEmailAndUsername(@PathVariable String email, @PathVariable String password) {
        LOGGER.info("Rest request to get email and password: {} {}", email, password);
        Customer customer = customerService.login(email, password);
        if (ObjectUtils.isEmpty(customer)) {
            throw new RuntimeException("Invalid email or password!");
        }
        return customer;
    }

}
