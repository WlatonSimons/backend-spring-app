package com.team5.morgage.models;

import jakarta.persistence.*;

@Entity
public class MortgageValue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "special_number")
    private float specialNumber;

    @Column(name = "management_fee")
    private float managementFee;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getSpecialNumber() {
        return specialNumber;
    }

    public void setSpecialNumber(float specialNumber) {
        this.specialNumber = specialNumber;
    }

    public float getManagementFee() {
        return managementFee;
    }

    public void setManagementFee(float managementFee) {
        this.managementFee = managementFee;
    }
}