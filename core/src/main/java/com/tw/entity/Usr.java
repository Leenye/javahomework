package com.tw.entity;

/**
 * Created by twer on 7/8/15.
 */
public class Usr {
    private  int id;
    private String name;
    private  String gender;
    private  int age;
    private  String email;

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Usr(int id, String name, String gender, int age, String email) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.email = email;
    }
}
