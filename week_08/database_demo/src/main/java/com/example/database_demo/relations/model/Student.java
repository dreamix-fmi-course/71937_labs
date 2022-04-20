package com.example.database_demo.relations.model;

import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Table
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private String family;

    @Column
    private Integer facultyNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "faculty")
    private Faculty faculty;
}
