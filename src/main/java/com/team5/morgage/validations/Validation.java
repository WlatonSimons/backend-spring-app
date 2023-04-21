package com.team5.morgage.validations;

import com.team5.morgage.exceptions.CustomException;
import com.team5.morgage.models.requests.MaxLoanRequest;
import com.team5.morgage.models.requests.MonthlyPaymentRequest;

import java.util.Arrays;
import java.util.List;

public class Validation {

    private static final List<String> validStatus = Arrays.asList("New", "In progress", "Done", "Rejected");
    private static final List<Integer> netIncomeStages = Arrays.asList(600, 650, 1000);
    private static final int COMPARE_PERCENT = 40;
    private static final int MIN_HOME_PRICE = 5000;
    private static final int MIN_DOWN_PAYMENT_PERCENT = 15;
    private static final int MAX_DOWN_PAYMENT_PERCENT = 99;
    private static final int MIN_MORTGAGE_TERM = 1;
    private static final int MAX_MORTGAGE_TERM = 30;

    public boolean isMaxLoanLogicValid(MaxLoanRequest maxLoanRequest) {
        float trueNetIncome = maxLoanRequest.getNetIncome() - maxLoanRequest.getMonthlyObligationAmount();

        float percent = maxLoanRequest.getMonthlyObligationAmount() * 100 / trueNetIncome;

        if (!maxLoanRequest.isSingleApplicant()) {
            if (trueNetIncome < netIncomeStages.get(2)) {
                throw new CustomException("Net income (" + (int) trueNetIncome + ") should be equal or more than 1000");
            }
        }

        switch (maxLoanRequest.getFamilyMember()) {
            case 0:
                if (trueNetIncome < netIncomeStages.get(0)) {
                    throw new CustomException("Net income (" + (int) trueNetIncome + ") should be equal or more than 600");
                }
                break;
            case 1:
                if (trueNetIncome < netIncomeStages.get(1)) {
                    throw new CustomException("Net income (" + (int) trueNetIncome + ") should be equal or more than 650");
                }
                break;
            case 2:
                if (trueNetIncome < netIncomeStages.get(2)) {
                    throw new CustomException("Net income (" + (int) trueNetIncome + ") should be equal or more than 1000");
                }
                break;
        }

        if (percent > COMPARE_PERCENT) {
            throw new CustomException("Current monthly obligations (" + (int) percent + "%) can`t be more than 40% of net income");
        }
        return true;
    }

    public boolean isMonthlyPaymentLogicValid(MonthlyPaymentRequest monthlyPaymentRequest) {
        float downPaymentPercent = monthlyPaymentRequest.getDownPayment() * 100 / monthlyPaymentRequest.getHomePrice();

        if (monthlyPaymentRequest.getHomePrice() < MIN_HOME_PRICE) {
            throw new CustomException("Min home price is " + MIN_HOME_PRICE);
        }
        if (downPaymentPercent < MIN_DOWN_PAYMENT_PERCENT || downPaymentPercent > MAX_DOWN_PAYMENT_PERCENT) {
            throw new CustomException("Down payment can`t be less than " + MIN_DOWN_PAYMENT_PERCENT
                    + "% and more than " + MAX_DOWN_PAYMENT_PERCENT + "%");
        }
        if (monthlyPaymentRequest.getMortgageTerm() < MIN_MORTGAGE_TERM
                || monthlyPaymentRequest.getMortgageTerm() > MAX_MORTGAGE_TERM) {

            throw new CustomException("Mortgage term can`t be shorter than " + MIN_MORTGAGE_TERM
                    + " year(s) and longer than " + MAX_MORTGAGE_TERM + " years");
        }
        return true;
    }

    public boolean isMortgageAmountValid(MonthlyPaymentRequest monthlyPaymentRequest) {
        if (!((monthlyPaymentRequest.getHomePrice() - monthlyPaymentRequest.getDownPayment())
                == monthlyPaymentRequest.getMortgageAmount())) {

            throw new CustomException("Mortgage amount should be - "
                    + (int) (monthlyPaymentRequest.getHomePrice() - monthlyPaymentRequest.getDownPayment()));
        } else {
            return true;
        }
    }

    public boolean isStatusCorrect(String newStatus) {
        if (validStatus.contains(newStatus)) {
            return true;
        } else {
            throw new CustomException("New status (" + newStatus + ") is not acceptable");
        }
    }
}
