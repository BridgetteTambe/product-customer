package com.bree.com.repository;

import com.bree.com.models.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {
    Status findByName(String name);
}
