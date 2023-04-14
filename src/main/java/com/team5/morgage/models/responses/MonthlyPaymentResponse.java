package com.team5.morgage.models.responses;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class MonthlyPaymentResponse {
    private float monthlyPayment;
    private float totalPayableAmount;
    private float interestCost;
}
