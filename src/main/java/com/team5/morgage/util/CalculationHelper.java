package com.team5.morgage.util;

public class CalculationHelper {

    private static final int MONTHS_IN_YEAR = 12;

    public float calculateInterestRate(float interestRate, float managementFee) {
        return interestRate + managementFee;
    }

    public float calculateInterestPaidInOneYear(float calculatedInterestRate, float mortgageAmount) {
        return calculatedInterestRate * mortgageAmount;
    }

    public float calculateInterestPaidDuringWholePeriod(float interestRate, float managementFee,
                                                        float mortgageAmount, float mortgageTerm) {
        return calculateInterestPaidInOneYear(calculateInterestRate(interestRate, managementFee), mortgageAmount) *
                mortgageTerm;
    }

    public float calculateTotalPayableAmount(float interestPaidDuringWholePeriod, float mortgageAmount) {
        return interestPaidDuringWholePeriod + mortgageAmount;
    }

    public float calculateMonthlyPayment(float totalPayableAmount, float mortgageTerm) {
        return totalPayableAmount / mortgageTerm / MONTHS_IN_YEAR;
    }
}
