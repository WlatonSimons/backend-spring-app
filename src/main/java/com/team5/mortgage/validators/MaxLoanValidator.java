package com.team5.mortgage.validators;

import com.team5.mortgage.exceptions.CustomException;
import com.team5.mortgage.models.requests.MaxLoanRequest;
import com.team5.mortgage.util.CalculationHelper;

public class MaxLoanValidator {
    private static final int FIRST_NET_INCOME_STAGE = 600;
    private static final int SECOND_NET_INCOME_STAGE = 650;
    private static final int THIRD_NET_INCOME_STAGE = 1000;

    private final CalculationHelper calculationHelper;

    public MaxLoanValidator() {
        this.calculationHelper = new CalculationHelper();
    }

    public boolean isMaxLoanLogicValid(MaxLoanRequest maxLoanRequest) {
        float trueNetIncome = calculationHelper.calculateTrueNetIncome(
                maxLoanRequest.getNetIncome(),
                maxLoanRequest.getMonthlyObligationAmount());

        if (!maxLoanRequest.isSingleApplicant()) {
            validateWithMultipleApplicants(trueNetIncome);
        }

        switch (maxLoanRequest.getFamilyMembers()) {
            case 0 -> validateWithZeroChildren(trueNetIncome);
            case 1 -> validateWithOneChild(trueNetIncome);
            case 2 -> validateWithTwoChildren(trueNetIncome);
        }

        return true;
    }

    private void validateWithZeroChildren(float trueNetIncome) {
        if (trueNetIncome < FIRST_NET_INCOME_STAGE) {
            throw new CustomException("Net income (" + (int) trueNetIncome + ") should be equal or more than 600");
        }
    }

    private void validateWithOneChild(float trueNetIncome) {
        if (trueNetIncome < SECOND_NET_INCOME_STAGE) {
            throw new CustomException("Net income (" + (int) trueNetIncome + ") should be equal or more than 650");
        }
    }

    private void validateWithTwoChildren(float trueNetIncome) {
        if (trueNetIncome < THIRD_NET_INCOME_STAGE) {
            throw new CustomException("Net income (" + (int) trueNetIncome + ") should be equal or more than 1000");
        }
    }

    private void validateWithMultipleApplicants(float trueNetIncome) {
        if (trueNetIncome < THIRD_NET_INCOME_STAGE) {
            throw new CustomException("Net income (" + (int) trueNetIncome + ") should be equal or more than 1000");
        }
    }
}
