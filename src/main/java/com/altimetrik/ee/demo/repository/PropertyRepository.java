package com.altimetrik.ee.demo.repository;

import com.altimetrik.ee.demo.entity.Property;
import com.altimetrik.ee.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Integer> {
    public Optional<List<Property>> findByUsername(String username);
}
