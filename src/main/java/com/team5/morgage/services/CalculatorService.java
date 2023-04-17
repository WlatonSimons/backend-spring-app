package com.team5.morgage.services;

import com.team5.morgage.exceptions.MortgageNotFoundException;
import com.team5.morgage.models.Application;
import com.team5.morgage.models.MortgageValue;
import com.team5.morgage.models.requests.MonthlyPaymentRequest;
import com.team5.morgage.models.responses.MonthlyPaymentResponse;
import com.team5.morgage.models.requests.MaxLoanRequest;
import com.team5.morgage.repositories.ApplicationRepository;
import com.team5.morgage.repositories.MortgageValueRepository;
import com.team5.morgage.util.CalculationHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    @Autowired
    private MortgageValueRepository mortgageValueRepository;

    @Autowired
    private ApplicationRepository applicationRepository;


    public float calculateMaxLoan(MaxLoanRequest request) {
        MortgageValue mortgageValue = mortgageValueRepository.findById(1L)
                .orElseThrow(() -> new MortgageNotFoundException("There are no mortgage values present"));

        // ToDo: validations

        return mortgageValue.getSpecialNumber() * request.getNetIncome();
    }

    public MonthlyPaymentResponse calculateMonthlyPayment(MonthlyPaymentRequest request) {
        MortgageValue mortgageValue = mortgageValueRepository.findById(1L)
                .orElseThrow(() -> new MortgageNotFoundException("There are no mortgage values present"));

        // ToDo: validations

        CalculationHelper calculationHelper = new CalculationHelper();

        float interestPaidDuringWholePeriod =
                calculationHelper.calculateInterestPaidDuringWholePeriod(request.getInterestRate(),
                        mortgageValue.getManagementFee(), request.getMortgageTerm(),  request.getMortgageAmount());

        float totalPayableAmount = calculationHelper.calculateTotalPayableAmount(interestPaidDuringWholePeriod,
                request.getMortgageAmount());

        return MonthlyPaymentResponse.builder()
                .totalPayableAmount(totalPayableAmount)
                .monthlyPayment(calculationHelper.calculateMonthlyPayment(totalPayableAmount,
                        request.getMortgageTerm()))
                .interestCost(interestPaidDuringWholePeriod)
                .build();
    }

    public Application saveSubmittedApplication(Application application) {

        // ToDo: validations

        return applicationRepository.save(application);
    }
}
