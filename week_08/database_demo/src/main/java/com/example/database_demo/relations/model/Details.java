package com.example.database_demo.relations.model;

import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Table
@Entity
public class Details {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column
    private String phone;

    @Column
    private String email;
}
