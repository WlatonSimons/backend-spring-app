package com.team5.morgage.validations;

import com.team5.morgage.exceptions.CustomException;
import com.team5.morgage.models.requests.MaxLoanRequest;
import com.team5.morgage.models.requests.MonthlyPaymentRequest;

public class Validation {

    public boolean isMaxLoanLogicValid(MaxLoanRequest maxLoanRequest) {
        float percent = maxLoanRequest.getMonthlyObligationAmount() * 100 / maxLoanRequest.getNetIncome();

        if (!maxLoanRequest.isSingleApplicant()) {
            if (maxLoanRequest.getNetIncome() < 1000) {
                throw new CustomException("Net income should be equal or more than 1000");
            }
        }
        if (maxLoanRequest.getFamilyMember() == 0) {
            if (maxLoanRequest.getNetIncome() < 600) {
                throw new CustomException("Net income should be equal or more than 600");
            }
        }
        if (maxLoanRequest.getFamilyMember() == 1) {
            if (maxLoanRequest.getNetIncome() < 650) {
                throw new CustomException("Net income should be equal or more than 650");
            }
        }
        if (maxLoanRequest.getFamilyMember() == 2) {
            if (maxLoanRequest.getNetIncome() < 1000) {
                throw new CustomException("Net income should be equal or more than 1000");
            }
        }
        if (percent > 40) {
            throw new CustomException("Current monthly obligations can`t be more than 40% of net income");
        }
        return true;
    }

    public boolean isMonthlyPaymentLogicValid(MonthlyPaymentRequest monthlyPaymentRequest) {
        float downPaymentPercent = monthlyPaymentRequest.getDownPayment() * 100 / monthlyPaymentRequest.getHomePrice();

        if (monthlyPaymentRequest.getHomePrice() < 5000) {
            throw new CustomException("Min home price is 5000");
        }
        if (downPaymentPercent < 15 || downPaymentPercent > 99) {
            throw new CustomException("Down payment can`t be less than 15% and more than 99%");
        }
        if (monthlyPaymentRequest.getMortgageTerm() < 1 || monthlyPaymentRequest.getMortgageTerm() > 30) {
            throw new CustomException("Mortgage term can`t be shorter than 1 year and longer than 30 years");
        }
        return true;
    }

    public boolean isMortgageAmountValid(MonthlyPaymentRequest monthlyPaymentRequest) {
        if (!((monthlyPaymentRequest.getHomePrice() - monthlyPaymentRequest.getDownPayment()) == monthlyPaymentRequest.getMortgageAmount())) {
            throw new CustomException("Mortgage amount should be homePrice - downPayment");
        } else {
            return true;
        }
    }
}
