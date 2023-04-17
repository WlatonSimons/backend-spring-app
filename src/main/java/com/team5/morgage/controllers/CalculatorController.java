package com.team5.morgage.controllers;

import com.team5.morgage.models.Application;
import com.team5.morgage.models.requests.MonthlyPaymentRequest;
import com.team5.morgage.models.responses.MonthlyPaymentResponse;
import com.team5.morgage.models.requests.MaxLoanRequest;
import com.team5.morgage.services.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @PostMapping("/calculator/maxLoan")
    public float calculateMaxLoan(@RequestBody MaxLoanRequest maxLoanRequest) {
        return calculatorService.calculateMaxLoan(maxLoanRequest);
    }

    @PostMapping("/calculator/monthlyPayment")
    public MonthlyPaymentResponse calculateMonthlyPayment(@RequestBody MonthlyPaymentRequest monthlyPaymentRequest) {
        return calculatorService.calculateMonthlyPayment(monthlyPaymentRequest);
    }

    @PostMapping("/calculator/submitApplication")
    public Application saveSubmittedApplication(@RequestBody Application application) {
        return calculatorService.saveSubmittedApplication(application);
    }
}
