package com.team5.mortgage.models.responses;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class MonthlyPaymentResponse {
    private int monthlyPayment;
    private int totalPayableAmount;
    private int interestCost;
}
