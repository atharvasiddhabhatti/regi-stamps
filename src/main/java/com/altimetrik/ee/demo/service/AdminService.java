package com.altimetrik.ee.demo.service;

import com.altimetrik.ee.demo.entity.Property;
import com.altimetrik.ee.demo.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AdminService {
    @Autowired
    private PropertyRepository propertyRepository;
    public Property patchProperty(Property property) {

        return propertyRepository.save(property);

    }

}
