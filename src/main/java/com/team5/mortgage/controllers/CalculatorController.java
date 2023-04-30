package com.team5.mortgage.controllers;

import com.team5.mortgage.models.requests.MaxLoanRequest;
import com.team5.mortgage.models.requests.MonthlyPaymentRequest;
import com.team5.mortgage.models.responses.MaxLoanResponse;
import com.team5.mortgage.models.responses.MonthlyPaymentResponse;
import com.team5.mortgage.services.CalculatorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/calculator")
@RestController
public class CalculatorController {

    @Autowired
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @PostMapping("/max-loan")
    public ResponseEntity<MaxLoanResponse> calculateMaxLoan(@RequestBody @Valid MaxLoanRequest maxLoanRequest) {
        return new ResponseEntity<>(calculatorService.calculateMaxLoan(maxLoanRequest), HttpStatus.CREATED);
    }

    @PostMapping("/monthly-payment")
    public ResponseEntity<MonthlyPaymentResponse> calculateMonthlyPayment(
            @RequestBody @Valid MonthlyPaymentRequest monthlyPaymentRequest) {
        return new ResponseEntity<>(
                calculatorService.calculateMonthlyPayment(monthlyPaymentRequest), HttpStatus.CREATED);
    }
}
