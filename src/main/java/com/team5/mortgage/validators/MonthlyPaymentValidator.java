package com.team5.mortgage.validators;

import com.team5.mortgage.exceptions.CustomException;
import com.team5.mortgage.models.requests.MonthlyPaymentRequest;
import com.team5.mortgage.util.CalculationHelper;

public class MonthlyPaymentValidator {
    private static final int MIN_HOME_PRICE = 5000;
    private static final int MIN_DOWN_PAYMENT_PERCENT = 15;
    private static final int MAX_DOWN_PAYMENT_PERCENT = 99;
    private static final int MIN_MORTGAGE_TERM = 1;
    private static final int MAX_MORTGAGE_TERM = 30;

    private final CalculationHelper calculationHelper;

    public MonthlyPaymentValidator() {
        this.calculationHelper = new CalculationHelper();
    }

    public boolean isMonthlyPaymentLogicValid(MonthlyPaymentRequest monthlyPaymentRequest) {
        float downPaymentPercent = calculationHelper.calculateDownPaymentPercent(
                monthlyPaymentRequest.getDownPayment(),
                monthlyPaymentRequest.getHomePrice());

        validateHomePrice(monthlyPaymentRequest.getHomePrice());
        validateDownPaymentPercent(downPaymentPercent);
        validateMortgageTerm(monthlyPaymentRequest.getMortgageTerm());

        return true;
    }

    public boolean isMortgageAmountValid(MonthlyPaymentRequest monthlyPaymentRequest) {
        validateMortgageAmount(
                monthlyPaymentRequest.getHomePrice(),
                monthlyPaymentRequest.getDownPayment(),
                monthlyPaymentRequest.getMortgageAmount());

        return true;
    }

    private void validateHomePrice(float homePrice) {
        if (homePrice < MIN_HOME_PRICE) {
            throw new CustomException("Min home price is " + MIN_HOME_PRICE);
        }
    }

    private void validateDownPaymentPercent(float downPaymentPercent) {
        if (downPaymentPercent < MIN_DOWN_PAYMENT_PERCENT || downPaymentPercent > MAX_DOWN_PAYMENT_PERCENT) {
            throw new CustomException("Down payment can`t be less than " + MIN_DOWN_PAYMENT_PERCENT
                    + "% and more than " + MAX_DOWN_PAYMENT_PERCENT + "%");
        }
    }

    private void validateMortgageTerm(int mortgageTerm) {
        if (mortgageTerm < MIN_MORTGAGE_TERM || mortgageTerm > MAX_MORTGAGE_TERM) {
            throw new CustomException("Mortgage term can`t be shorter than " + MIN_MORTGAGE_TERM
                    + " year(s) and longer than " + MAX_MORTGAGE_TERM + " years");
        }
    }

    private void validateMortgageAmount(float homePrice, float downPayment, float mortgageAmount) {
        if ((homePrice - downPayment) != mortgageAmount) {
            throw new CustomException("Mortgage amount should be - "
                    + (int) (homePrice - downPayment));
        }
    }
}
