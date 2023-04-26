package com.team5.mortgage.util;

public class CalculationHelper {

    private static final int MONTHS_IN_YEAR = 12;
    private static final float MAX_MONTHLY_PAYABLE_PERCENT = 0.4F;

    public float calculateInterestRate(float interestRate, float managementFee) {
        return interestRate + managementFee;
    }

    public float calculateInterestPaidInOneYear(float calculatedInterestRate, float mortgageAmount) {
        return calculatedInterestRate * mortgageAmount / 100;
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

    public float calculateTrueNetIncome(float netIncome, float monthlyObligationAmount) {
        return netIncome - monthlyObligationAmount;
    }

    public float calculateMaxLoan(float netIncome, float monthlyObligationAmount, float specialNumber) {
        return calculateTrueNetIncome(netIncome, monthlyObligationAmount) * specialNumber;
    }

    public float calculateMaxLoanMonthlyPayment(float netIncome, float monthlyObligationAmount) {
        return calculateTrueNetIncome(netIncome, monthlyObligationAmount) * MAX_MONTHLY_PAYABLE_PERCENT;
    }

    public float calculateDownPaymentPercent(float downPayment, float homePrice) {
        return downPayment * 100 / homePrice;
    }
}
