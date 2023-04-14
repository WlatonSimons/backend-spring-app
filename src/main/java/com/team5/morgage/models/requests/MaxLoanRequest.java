package com.team5.morgage.models.requests;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class MaxLoanRequest {
    private boolean isJustMe;
    private float netIncome;
    private int familyMembers;
    private float monthlyObligation;
}
