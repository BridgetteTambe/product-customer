package com.bree.com.resources;

import com.bree.com.models.Address;
import com.bree.com.service.AddressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:4200/", "http://localhost:4200","http://localhost:4201","https://product-admin-view.vercel.app/","https://product-customer-view.vercel.app/"})
public class AddressResource {
    @Autowired
    AddressService addressService;
    private Logger LOGGER = LoggerFactory.getLogger(AddressResource.class);

    @PostMapping("/address")
    public Address saveAddressInfo(@RequestBody Address address) throws Exception {
        LOGGER.info("Rest request to save address data:{}");
        if (address.getId() != null) {
            throw new Exception("Cant save address with id");
        }
        return addressService.save(address);
    }

    @PutMapping("/address")
    public Address updateAddress(@RequestBody Address address) throws Exception {
        LOGGER.info("Rest request to update address with id:{}");
        if (address.getId() == null) {
            throw new Exception("Cant update address with a null id:{}");
        }
        return addressService.save(address);

    }

    @GetMapping("/address/{id}")
    public Address getAddressById(@PathVariable Long id) {
        LOGGER.info("Rest request to get address  by id:{}", id);
        return addressService.findById(id);
    }

    @GetMapping("/address")
    List<Address> findAll() {
        LOGGER.info("Rest request to get all address:");
        return addressService.findAll();
    }

    @DeleteMapping("/address/{id}")
    public void deleteById(@PathVariable Long id) {
        LOGGER.info("Rest request to delete address by id:{}");
        addressService.deleteById(id);
    }

    @DeleteMapping("/address")
    public void deleteAll() {
        LOGGER.info("Rest request to delete address:");
        addressService.deleteAll();
    }

}
