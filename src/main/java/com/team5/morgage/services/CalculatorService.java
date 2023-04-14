package com.team5.morgage.services;

import com.team5.morgage.exceptions.MortgageNotFoundException;
import com.team5.morgage.models.MortgageValue;
import com.team5.morgage.models.requests.MonthlyPaymentRequest;
import com.team5.morgage.models.responses.MonthlyPaymentResponse;
import com.team5.morgage.models.requests.MaxLoanRequest;
import com.team5.morgage.repositories.MortgageValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    @Autowired
    private MortgageValueRepository mortgageValueRepository;

    private static final int MONTHS_IN_YEAR = 12;
    private static final Long FIRST_ROW = 1L;

    public float calculateMaxLoan(MaxLoanRequest request) {
        MortgageValue mortgageValue = mortgageValueRepository.findById(FIRST_ROW)
                .orElseThrow(() -> new MortgageNotFoundException("There are no mortgage values present"));

        // ToDo: validations

        return mortgageValue.getSpecialNumber() * request.getNetIncome();
    }

    public MonthlyPaymentResponse calculateMonthlyPayment(MonthlyPaymentRequest request) {
        MortgageValue mortgageValue = mortgageValueRepository.findById(FIRST_ROW)
                .orElseThrow(() -> new MortgageNotFoundException("There are no mortgage values present"));

        // ToDo: validations

        float newInterestRate = request.getInterestRate() + mortgageValue.getManagementFee();
        float interestPaidInOneYear = newInterestRate * request.getMortgageAmount();
        float interestPaidDuringWholePeriod = interestPaidInOneYear * request.getMortgageTerm();
        float totalPayableAmount = interestPaidDuringWholePeriod + request.getMortgageAmount();

        return MonthlyPaymentResponse.builder()
                .totalPayableAmount(totalPayableAmount)
                .monthlyPayment(totalPayableAmount / request.getMortgageTerm() / MONTHS_IN_YEAR)
                .interestCost(interestPaidDuringWholePeriod)
                .build();
    }
}
