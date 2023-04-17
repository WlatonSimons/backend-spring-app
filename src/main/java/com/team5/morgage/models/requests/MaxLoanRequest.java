package com.team5.morgage.models.requests;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class MaxLoanRequest {
    private boolean isSingleApplicant;
    private float netIncome;
    private int dependants;
    private float monthlyObligationAmount;
}
