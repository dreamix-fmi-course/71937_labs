package com.example.database_demo.demo.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table
public class Cart {
    @OneToMany(mappedBy = "cart")
    private Set<Item> items;
}
