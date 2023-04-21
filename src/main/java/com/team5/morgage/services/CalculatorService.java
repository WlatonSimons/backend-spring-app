package com.team5.morgage.services;

import com.team5.morgage.exceptions.CustomException;
import com.team5.morgage.models.MortgageValue;
import com.team5.morgage.models.requests.MonthlyPaymentRequest;
import com.team5.morgage.models.responses.MonthlyPaymentResponse;
import com.team5.morgage.models.requests.MaxLoanRequest;
import com.team5.morgage.repositories.MortgageValueRepository;
import com.team5.morgage.util.CalculationHelper;
import com.team5.morgage.validations.Validation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    @Autowired
    private final MortgageValueRepository mortgageValueRepository;

    private final Validation validator;

    public CalculatorService(MortgageValueRepository mortgageValueRepository) {
        this.mortgageValueRepository = mortgageValueRepository;
        this.validator = new Validation();
    }

    public int calculateMaxLoan(@Valid MaxLoanRequest maxLoanRequest) {
        MortgageValue mortgageValue = mortgageValueRepository.findById(1L)
                .orElseThrow(() -> new CustomException("There are no mortgage values present"));

        if (validator.isMaxLoanLogicValid(maxLoanRequest)) {
            return (int) (mortgageValue.getSpecialNumber() * (maxLoanRequest.getNetIncome() - maxLoanRequest.getMonthlyObligationAmount()));
        }
        return -1;
    }

    public MonthlyPaymentResponse calculateMonthlyPayment(MonthlyPaymentRequest monthlyPaymentRequest) {
        MortgageValue mortgageValue = mortgageValueRepository.findById(1L)
                .orElseThrow(() -> new CustomException("There are no mortgage values present"));


        if (validator.isMortgageAmountValid(monthlyPaymentRequest)) {
            if (validator.isMonthlyPaymentLogicValid(monthlyPaymentRequest)) {
                CalculationHelper calculationHelper = new CalculationHelper();

                float interestPaidDuringWholePeriod =
                        calculationHelper.calculateInterestPaidDuringWholePeriod(monthlyPaymentRequest.getInterestRate(),
                                mortgageValue.getManagementFee(), monthlyPaymentRequest.getMortgageTerm(),  monthlyPaymentRequest.getMortgageAmount());

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
