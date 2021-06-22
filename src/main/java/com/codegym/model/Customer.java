package com.codegym.model;

import javax.persistence.*;

@Entity
@Table
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private String firstName;
    private String LastName;
    @ManyToOne
    @JoinColumn(name = "province_id")
    private Province province;
    public Customer() {
    }

    public Customer(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        LastName = lastName;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }
}
