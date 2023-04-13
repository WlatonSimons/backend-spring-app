package com.team5.morgage.models;

public class SecondResponse {

    private float monthlyPayment;
    private float totalPayableAmount;
    private float interestCost;

    public float getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(float monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public float getTotalPayableAmount() {
        return totalPayableAmount;
    }

    public void setTotalPayableAmount(float totalPayableAmount) {
        this.totalPayableAmount = totalPayableAmount;
    }

    public float getInterestCost() {
        return interestCost;
    }

    public void setInterestCost(float interestCost) {
        this.interestCost = interestCost;
    }
}
