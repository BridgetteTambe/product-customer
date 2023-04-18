package com.bree.com.service.impl;

import com.bree.com.models.Address;
import com.bree.com.repository.AddressRepository;
import com.bree.com.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressRepository addressRepository;
    @Override
    public Address save(Address address) {
        return addressRepository.save(address);
    }

    @Override
   public List <Address> saveAll(List<Address> address) {
        return addressRepository.saveAll(address);
    }

    @Override
    public Address updateAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address findById(Long id) {
        Optional<Address>findById = addressRepository.findById(id);

        return findById.orElse(null);
    }

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
addressRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
addressRepository.deleteAll();
    }
}
