package com.example.database_demo.demo.model;

import javax.persistence.*;

@Entity
@Table(indexes = { @Index(columnList = "brand")})
public class Car {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column
    private String brand;
}
