package com.team5.morgage.controllers;

import com.team5.morgage.models.requests.MonthlyPaymentRequest;
import com.team5.morgage.models.responses.MonthlyPaymentResponse;
import com.team5.morgage.models.requests.MaxLoanRequest;
import com.team5.morgage.services.CalculatorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @PostMapping("/calculator/maxLoan")
    public ResponseEntity<Float> calculateMaxLoan(@RequestBody @Valid MaxLoanRequest maxLoanRequest) {
        return new ResponseEntity<>(calculatorService.calculateMaxLoan(maxLoanRequest), HttpStatus.CREATED);
    }

    @PostMapping("/calculator/monthlyPayment")
    public ResponseEntity<MonthlyPaymentResponse> calculateMonthlyPayment(
            @RequestBody @Valid MonthlyPaymentRequest monthlyPaymentRequest) {
        return new ResponseEntity<>(
                calculatorService.calculateMonthlyPayment(monthlyPaymentRequest), HttpStatus.CREATED);
    }
}