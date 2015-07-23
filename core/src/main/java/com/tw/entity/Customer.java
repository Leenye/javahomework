package com.tw.entity;

import javax.persistence.*;

/**
 * Created by twer on 7/21/15.
 */
@Entity
@Table(name="customer")
public class Customer {
    private int id;
    private String name;

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Customer(){

    }

    public Customer(String name ){
        this.name = name;
    }

    public Customer(int id, String name ) {
        this.id = id;
        this.name = name;
    }
}


