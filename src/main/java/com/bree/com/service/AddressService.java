package com.bree.com.service;


import com.bree.com.models.Address;
import com.bree.com.models.Customer;

import java.util.List;

public interface AddressService {

    public Address save(Address address);

   public List <Address> saveAll(List<Address> address);

    public Address updateAddress(Address address);

    public Address findById(Long id);

    List<Address>findAll();

    public void deleteById(Long id);

    public void deleteAll();
}
