package com.altimetrik.ee.demo.repository;

import com.altimetrik.ee.demo.entity.Property;
import com.altimetrik.ee.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<Property, Integer> {
}
