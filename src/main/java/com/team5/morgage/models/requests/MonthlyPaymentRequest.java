package com.team5.morgage.models.requests;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class MonthlyPaymentRequest {

    @NotNull(message = "Home price is mandatory")
    @PositiveOrZero(message = "Home price can`t be negative value")
    private float homePrice;

    @NotNull(message = "Mortgage amount is mandatory")
    @PositiveOrZero(message = "Mortgage amount can`t be negative value")
    private float mortgageAmount;

    @NotNull(message = "Down payment is mandatory")
    @PositiveOrZero(message = "Down payment can`t be negative value")
    private float downPayment;

    @NotNull(message = "Interest rate is mandatory")
    @PositiveOrZero(message = "Interest rate can`t be negative value")
    private float interestRate;

    @NotNull(message = "Mortgage term is mandatory")
    @PositiveOrZero(message = "Mortgage term can`t be negative value")
    private int mortgageTerm;
}
