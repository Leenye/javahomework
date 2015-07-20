package com.tw.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by twer on 7/19/15.
 */
@Entity
@Table(name="employee_table")
public class Employee {//employee_id
    private int employee_id;
    private String role;
    private Usr usr;



    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usr_id")
    public Usr getUsr(){
        return usr;
    }
    public void setUsr(Usr usr){
        this.usr = usr;
    }

    @Id
//    @GeneratedValue
    @Column(name = "employee_id")
    public int getEmployee_id(){
        return employee_id;
    }
    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    @Column(name="role")
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
}
