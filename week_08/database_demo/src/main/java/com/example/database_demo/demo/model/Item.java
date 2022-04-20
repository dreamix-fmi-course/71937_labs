package com.example.database_demo.demo.model;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Item {
    @ManyToOne
    @JoinColumn(name="cart_id", nullable = false)
    private Cart cart;
}
