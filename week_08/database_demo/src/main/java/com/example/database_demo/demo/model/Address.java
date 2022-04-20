package com.example.database_demo.demo.model;

import org.springframework.data.annotation.Id;

import javax.persistence.*;

// ONE TO ONE RELATION
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String street;

    @Column
    private String city;

    @OneToOne(mappedBy = "itsAddress")
    private User user;
}
