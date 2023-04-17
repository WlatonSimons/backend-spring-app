package com.team5.morgage.models.requests;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class MaxLoanRequest {
    private boolean isSingleApplicant;
    private float netIncome;
    private int dependants;
    private float monthlyObligationAmount;
}
