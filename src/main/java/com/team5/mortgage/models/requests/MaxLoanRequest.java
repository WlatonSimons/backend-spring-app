package com.team5.mortgage.models.requests;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class MaxLoanRequest {
    @NotNull(message = "Single or not radio button is mandatory")
    private boolean isSingleApplicant;

    @NotNull(message = "Net income is mandatory")
    @PositiveOrZero(message = "Net Income can`t be negative value")
    private float netIncome;

    @NotNull(message = "Family members are mandatory")
    @PositiveOrZero(message = "Family members can`t be negative value")
    private int familyMember;

    @NotNull(message = "Monthly Obligation amount is mandatory")
    @PositiveOrZero(message = "Monthly Obligation amount can`t be negative value")
    private float monthlyObligationAmount;
}
