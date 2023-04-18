package com.team5.morgage.validations;

import com.team5.morgage.models.requests.MaxLoanRequest;
import com.team5.morgage.models.requests.MonthlyPaymentRequest;

public class Validation {

    public boolean isMaxLoanLogicValid(MaxLoanRequest maxLoanRequest) {
        float percent = maxLoanRequest.getMonthlyObligationAmount() * 100 / maxLoanRequest.getNetIncome();

        if (!maxLoanRequest.isSingleApplicant()) {
            if (maxLoanRequest.getNetIncome() < 1000) {
                return false;
            }
        }
        if (maxLoanRequest.getFamilyMember() == 0) {
            if (maxLoanRequest.getNetIncome() < 600) {
                return false;
            }
        }
        if (maxLoanRequest.getFamilyMember() == 1) {
            if (maxLoanRequest.getNetIncome() < 650) {
                return false;
            }
        }
        if (maxLoanRequest.getFamilyMember() == 2) {
            if (maxLoanRequest.getNetIncome() < 1000) {
                 return false;
            }
        }
        return !(percent > 40);
    }

    public boolean isMonthlyPaymentLogicValid(MonthlyPaymentRequest monthlyPaymentRequest) {
        float downPaymentPercent = monthlyPaymentRequest.getDownPayment() * 100 / monthlyPaymentRequest.getHomePrice();

        if (monthlyPaymentRequest.getHomePrice() < 5000) {
            return false;
        }
        if (downPaymentPercent < 15 || downPaymentPercent > 99) {
            return false;
        }
        return monthlyPaymentRequest.getMortgageTerm() >= 1 && monthlyPaymentRequest.getMortgageTerm() <= 30;
    }
}
