package com.team5.mortgage.models.requests;

import jakarta.validation.constraints.PositiveOrZero;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class MaxLoanRequest {
    //    @NotNull(message = "Single or not radio button is mandatory")
    private boolean isSingleApplicant;

    @PositiveOrZero(message = "Net Income can`t be negative value")
    private float netIncome;

    @PositiveOrZero(message = "Dependants can`t be negative value")
    private int familyMember;

    @PositiveOrZero(message = "Monthly Obligation can`t be negative value")
    private float monthlyObligationAmount;
}
