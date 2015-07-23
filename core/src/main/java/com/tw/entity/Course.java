package com.tw.entity;

import javax.persistence.*;

/**
 * Created by twer on 7/17/15.
 */

@Entity
@Table(name="course")
public class Course {
    private  int id;
    private String name;
    private  String details;

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="details")
    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Course(){

    }

    public Course(String name, String details) {
        this.name = name;
        this.details = details;
    }

    public Course(int id, String name, String details) {
        this.id = id;
        this.name = name;
        this.details = details;
    }
}
