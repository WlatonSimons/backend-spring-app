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

    @PostMapping("/maxLoan")
    public ResponseEntity<Integer> calculateMaxLoan(@RequestBody @Valid MaxLoanRequest maxLoanRequest) {
        return new ResponseEntity<>(calculatorService.calculateMaxLoan(maxLoanRequest), HttpStatus.CREATED);
    }

    @PostMapping("/monthlyPayment")
    public ResponseEntity<MonthlyPaymentResponse> calculateMonthlyPayment(
            @RequestBody @Valid MonthlyPaymentRequest monthlyPaymentRequest) {
        return new ResponseEntity<>(
                calculatorService.calculateMonthlyPayment(monthlyPaymentRequest), HttpStatus.CREATED);
    }
}
