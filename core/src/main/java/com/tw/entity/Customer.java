package com.tw.entity;

import javax.persistence.*;

/**
 * Created by twer on 7/21/15.
 */
@Entity
@Table(name="customer_table")
public class Customer {
    private int id;
    private String name;
    private Employee employee;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coach_id")
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer(){

    }

    public Customer(String name,Employee employee){
        this.name = name;
        this.employee =  employee;
    }

    public Customer(int id, String name, Employee employee) {
        this.id = id;
        this.name = name;
        this.employee = employee;
    }
}


