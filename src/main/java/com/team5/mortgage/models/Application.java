package com.team5.mortgage.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "First name can`t be empty or null")
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotNull(message = "Last name can`t be empty or null")
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @NotNull(message = "Email can`t be empty or null")
    @Email(message = "Email must be well-formed email address")
    @Column(name = "email", nullable = false)
    private String email;
    @NotNull(message = "Phone number can`t be empty or null")
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @NotNull(message = "Personal number can`t be empty or null")
    @Column(name = "personal_number", nullable = false)
    private String personalNumber;

    @NotNull(message = "Net income is mandatory")
    @PositiveOrZero(message = "Net income can`t be negative value")
    @Column(name = "net_income", nullable = false)
    private float netIncome;

    @NotNull(message = "Children amount is mandatory")
    @PositiveOrZero(message = "Children amount can`t be negative value")
    @Column(name = "children_amount", nullable = false)
    private int childrenAmount;

    @NotNull(message = "Education can`t be empty or null")
    @Column(name = "education", nullable = false)
    private String education;

    @NotNull(message = "Employer can`t be empty or null")
    @Column(name = "employer", nullable = false)
    private String employer;

    @NotNull(message = "Position can`t be empty or null")
    @Column(name = "position", nullable = false)
    private String position;

    @NotNull(message = "Time employed can`t be empty or null")
    @Column(name = "time_employed", nullable = false)
    private String timeEmployed;

    @NotNull(message = "Contract type can`t be empty or null")
    @Column(name = "contract_type", nullable = false)
    private String contractType;

    @NotNull(message = "Are there financial obligations radio button is mandatory")
    @Column(name = "are_financial_obligations", nullable = false)
    private boolean financialObligations;

    @NotNull(message = "Monthly obligations are mandatory")
    @PositiveOrZero(message = "Monthly obligations can`t be negative value")
    @Column(name = "monthly_obligations", nullable = false)
    private float monthlyObligations;

    @NotNull(message = "Loan amount is mandatory")
    @PositiveOrZero(message = "Loan amount can`t be negative value")
    @Column(name = "loan_amount", nullable = false)
    private float loanAmount;

    @NotNull(message = "Loan purpose can`t be empty or null")
    @Column(name = "loan_purpose", nullable = false)
    private String loanPurpose;

    @NotNull(message = "Term of loan type can`t be empty or null")
    @Column(name = "term_of_loan", nullable = false)
    private String termOfLoan;

    @NotNull(message = "Property type can`t be empty or null")
    @Column(name = "property_type", nullable = false)
    private String propertyType;

    @NotNull(message = "Property price is mandatory")
    @PositiveOrZero(message = "Property price can`t be negative value")
    @Column(name = "property_price", nullable = false)
    private float propertyPrice;

    @NotNull(message = "Evaluated property price is mandatory")
    @PositiveOrZero(message = "Evaluated property price can`t be negative value")
    @Column(name = "evaluated_property_price", nullable = false)
    private float evaluatedPropertyPrice;

    @NotNull(message = "Is there co borrower radio button is mandatory")
    @Column(name = "is_co_borrower", nullable = false)
    private boolean coBorrower;

    @Column(name = "co_borrower_first_name")
    private String coBorrowerFirstName;

    @Column(name = "co_borrower_last_name")
    private String coBorrowerLastName;

    @Column(name = "co_borrower_personal_number")
    private String coBorrowerPersonalNumber;

    @NotNull(message = "Is there a certification radio button is mandatory")
    @Column(name = "is_certification", nullable = false)
    private boolean certification;

    @Column(name = "date", nullable = false)
    private Timestamp date;

    @Column(name = "status", nullable = false)
    private String status;
}
