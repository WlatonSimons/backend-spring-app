package com.team5.mortgage.models.responses;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class MaxLoanResponse {
    private float maxLoan;
    private float maxMonthlyLoanPayment;
}
