package com.altimetrik.ee.demo.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
public class MyEntityTableTest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min = 4, max = 255, message = "Minimum username length: 4 characters")
    @Column(unique = true, nullable = false)
    private String username;

    @Column(unique = true, nullable = false)
    private String email;
}
