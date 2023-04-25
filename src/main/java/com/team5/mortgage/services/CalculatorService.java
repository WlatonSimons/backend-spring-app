package com.team5.mortgage.services;

import com.team5.mortgage.models.requests.MonthlyPaymentRequest;
import com.team5.mortgage.models.responses.MonthlyPaymentResponse;
import com.team5.mortgage.models.requests.MaxLoanRequest;
import com.team5.mortgage.util.CalculationHelper;
import com.team5.mortgage.validations.Validation;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    private final Validation validator;
    private static final float SPECIAL_NUMBER = Float.parseFloat(System.getenv("SPECIAL_NUMBER"));
    private static final float MANAGEMENT_FEE = Float.parseFloat(System.getenv("MANAGEMENT_FEE"));

    public CalculatorService() {
        this.validator = new Validation();
    }

    public int calculateMaxLoan(@Valid MaxLoanRequest maxLoanRequest) {
        if (validator.isMaxLoanLogicValid(maxLoanRequest)) {
            return (int) (SPECIAL_NUMBER * (maxLoanRequest.getNetIncome() - maxLoanRequest.getMonthlyObligationAmount()));
        }
        return -1;
    }

    public MonthlyPaymentResponse calculateMonthlyPayment(MonthlyPaymentRequest monthlyPaymentRequest) {
        if (validator.isMortgageAmountValid(monthlyPaymentRequest)) {
            if (validator.isMonthlyPaymentLogicValid(monthlyPaymentRequest)) {
                CalculationHelper calculationHelper = new CalculationHelper();

                float interestPaidDuringWholePeriod =
                        calculationHelper.calculateInterestPaidDuringWholePeriod(monthlyPaymentRequest.getInterestRate(),
                                MANAGEMENT_FEE, monthlyPaymentRequest.getMortgageTerm(),  monthlyPaymentRequest.getMortgageAmount());

                float totalPayableAmount = calculationHelper.calculateTotalPayableAmount(interestPaidDuringWholePeriod,
                        monthlyPaymentRequest.getMortgageAmount());

                return MonthlyPaymentResponse.builder()
                        .totalPayableAmount((int) totalPayableAmount)
                        .monthlyPayment((int) calculationHelper.calculateMonthlyPayment(totalPayableAmount,
                                monthlyPaymentRequest.getMortgageTerm()))
                        .interestCost((int) interestPaidDuringWholePeriod)
                        .build();
            }
        }
        return MonthlyPaymentResponse.builder()
                .totalPayableAmount(-1)
                .monthlyPayment(-1)
                .interestCost(-1)
                .build();
    }
}
