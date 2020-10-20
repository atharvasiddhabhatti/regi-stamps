package com.altimetrik.ee.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    String firstName;
    @Column
    String lastName;
    @Column
    String address;
    @Column
    String city;
    @Column
    String State;
    @Column
    int zip;
    @Column
    int regno;
    @Column
    int propertyno;
    @Column
    float area;
    @Column
    int surveyno;
    @Column
    String type;
    @Column
    String email;
    @Column
    String status;
}
