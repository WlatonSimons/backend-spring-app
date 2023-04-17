package com.team5.morgage.models.requests;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class MonthlyPaymentRequest {
    private float homePrice;
    private float mortgageAmount;
    private float downPayment;
    private float interestRate;
    private int mortgageTerm;
}
