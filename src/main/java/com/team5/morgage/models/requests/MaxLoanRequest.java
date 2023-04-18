package com.team5.morgage.models.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
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

    @NotNull(message = "Dependants is mandatory, if none put 0(zero)")
    @PositiveOrZero(message = "Dependants must be 0 or more")
    private int familyMember;

    @NotNull(message = "Monthly Obligation is mandatory, if none put 0(zero)")
    @PositiveOrZero(message = "Monthly Obligation can`t be negative value")
    private float monthlyObligationAmount;
}
