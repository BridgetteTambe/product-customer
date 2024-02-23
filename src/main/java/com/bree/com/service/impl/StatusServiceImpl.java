package com.bree.com.service.impl;

import com.bree.com.models.Customer;
import com.bree.com.models.Status;
import com.bree.com.repository.StatusRepository;
import com.bree.com.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatusServiceImpl implements StatusService {


    StatusRepository statusRepository;

    public  StatusServiceImpl(StatusRepository statusRepository){
        this.statusRepository = statusRepository;
    }
    @Override
    public Status findByName(String name) {
        return this.statusRepository.findByName(name);
    }

    @Override
    public Status save(Status status) throws Exception {
        return statusRepository.save(status);
    }

    @Override
    public Page<Status> findAll(Pageable pageable) {
        return statusRepository.findAll(pageable);
    }

    @Override
    public Status findById(Long id) {
        Optional<Status> findById = statusRepository.findById(id);
        return findById.orElse(null) ;
    }

    @Override
    public void delete(Status status) {
        statusRepository.delete(status);
    }
}
