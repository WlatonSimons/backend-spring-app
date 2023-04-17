package com.team5.morgage.models;

import jakarta.persistence.*;

@Entity
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "personal_code", nullable = false)
    private int personalNumber;

    @Column(name = "net_income", nullable = false)
    private float netIncome;

    @Column(name = "children_amount", nullable = false)
    private int childrenAmount;

    @Column(name = "education", nullable = false)
    private String education;

    @Column(name = "employer", nullable = false)
    private String employer;

    @Column(name = "position", nullable = false)
    private String position;

    @Column(name = "time_employed", nullable = false)
    private String timeEmployed;

    @Column(name = "contract_type", nullable = false)
    private String contractType;

    @Column(name = "are_financial_Obligations", nullable = false)
    private boolean financialObligations;

    @Column(name = "monthly_obligations", nullable = false)
    private float monthlyObligations;

    @Column(name = "laon_amount", nullable = false)
    private float loanAmount;

    @Column(name = "loan_purpose", nullable = false)
    private String loanPurpose;

    @Column(name = "term_of_loan", nullable = false)
    private String termOfLoan;

    @Column(name = "property_type", nullable = false)
    private String propertyType;

    @Column(name = "property_price", nullable = false)
    private float propertyPrice;

    @Column(name = "evaluated_property_price", nullable = false)
    private float evaluatedPropertyPrice;

    @Column(name = "is_co_borrower", nullable = false)
    private boolean coBorrower;

    @Column(name = "co_borrower_name")
    private String coBorrowerName;

    @Column(name = "co_borrower_personal_number")
    private int coBorrowerPersonalNumber;

    @Column(name = "is_certification", nullable = false)
    private boolean certification;
}
