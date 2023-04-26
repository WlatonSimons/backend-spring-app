package com.team5.mortgage.services;

import com.team5.mortgage.models.requests.MaxLoanRequest;
import com.team5.mortgage.models.requests.MonthlyPaymentRequest;
import com.team5.mortgage.models.responses.MaxLoanResponse;
import com.team5.mortgage.models.responses.MonthlyPaymentResponse;
import com.team5.mortgage.util.CalculationHelper;
import com.team5.mortgage.validators.MaxLoanValidator;
import com.team5.mortgage.validators.MonthlyPaymentValidator;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    private static final float SPECIAL_NUMBER = Float.parseFloat(System.getenv("SPECIAL_NUMBER"));
    private static final float MANAGEMENT_FEE = Float.parseFloat(System.getenv("MANAGEMENT_FEE"));

    private final MaxLoanValidator maxLoanValidator;
    private final MonthlyPaymentValidator monthlyPaymentValidator;

    private final CalculationHelper calculationHelper;

    public CalculatorService() {
        this.maxLoanValidator = new MaxLoanValidator();
        this.monthlyPaymentValidator = new MonthlyPaymentValidator();
        this.calculationHelper = new CalculationHelper();
    }

    public MaxLoanResponse calculateMaxLoan(@Valid MaxLoanRequest maxLoanRequest) {
        if (maxLoanValidator.isMaxLoanLogicValid(maxLoanRequest)) {
            return MaxLoanResponse.builder()
                    .maxLoan((int) calculationHelper.calculateMaxLoan(
                            maxLoanRequest.getNetIncome(),
                            maxLoanRequest.getMonthlyObligationAmount(),
                            SPECIAL_NUMBER))
                    .maxMonthlyLoanPayment((int) calculationHelper.calculateMaxLoanMonthlyPayment(
                            maxLoanRequest.getNetIncome(),
                            maxLoanRequest.getMonthlyObligationAmount()))
                    .build();
        }
        return MaxLoanResponse.builder()
                .maxLoan(-1)
                .maxMonthlyLoanPayment(-1)
                .build();
    }

    public MonthlyPaymentResponse calculateMonthlyPayment(MonthlyPaymentRequest monthlyPaymentRequest) {
        if (monthlyPaymentValidator.isMortgageAmountValid(monthlyPaymentRequest)) {
            if (monthlyPaymentValidator.isMonthlyPaymentLogicValid(monthlyPaymentRequest)) {
                CalculationHelper calculationHelper = new CalculationHelper();

                float interestPaidDuringWholePeriod =
                        calculationHelper.calculateInterestPaidDuringWholePeriod(monthlyPaymentRequest.getInterestRate(),
                                MANAGEMENT_FEE, monthlyPaymentRequest.getMortgageTerm(), monthlyPaymentRequest.getMortgageAmount());

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
