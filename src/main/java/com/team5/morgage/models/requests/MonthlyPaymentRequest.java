package com.team5.morgage.models.requests;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class MonthlyPaymentRequest {
    private float homePrice;
    private float mortgageAmount;
    private float downPayment;
    private float interestRate;
    private int mortgageTerm;
}
