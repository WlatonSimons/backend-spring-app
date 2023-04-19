package com.team5.morgage.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.sql.Timestamp;

@Entity
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
    //  @PositiveOrZero(message = "Monthly obligations can`t be negative value")
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

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }

    public float getNetIncome() {
        return netIncome;
    }

    public void setNetIncome(float netIncome) {
        this.netIncome = netIncome;
    }

    public int getChildrenAmount() {
        return childrenAmount;
    }

    public void setChildrenAmount(int childrenAmount) {
        this.childrenAmount = childrenAmount;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTimeEmployed() {
        return timeEmployed;
    }

    public void setTimeEmployed(String timeEmployed) {
        this.timeEmployed = timeEmployed;
    }

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    public boolean isFinancialObligations() {
        return financialObligations;
    }

    public void setFinancialObligations(boolean financialObligations) {
        this.financialObligations = financialObligations;
    }

    public float getMonthlyObligations() {
        return monthlyObligations;
    }

    public void setMonthlyObligations(float monthlyObligations) {
        this.monthlyObligations = monthlyObligations;
    }

    public float getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(float loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getLoanPurpose() {
        return loanPurpose;
    }

    public void setLoanPurpose(String loanPurpose) {
        this.loanPurpose = loanPurpose;
    }

    public String getTermOfLoan() {
        return termOfLoan;
    }

    public void setTermOfLoan(String termOfLoan) {
        this.termOfLoan = termOfLoan;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public float getPropertyPrice() {
        return propertyPrice;
    }

    public void setPropertyPrice(float propertyPrice) {
        this.propertyPrice = propertyPrice;
    }

    public float getEvaluatedPropertyPrice() {
        return evaluatedPropertyPrice;
    }

    public void setEvaluatedPropertyPrice(float evaluatedPropertyPrice) {
        this.evaluatedPropertyPrice = evaluatedPropertyPrice;
    }

    public boolean isCoBorrower() {
        return coBorrower;
    }

    public void setCoBorrower(boolean coBorrower) {
        this.coBorrower = coBorrower;
    }

    public String getCoBorrowerFirstName() {
        return coBorrowerFirstName;
    }

    public void setCoBorrowerFirstName(String coBorrowerFirstName) {
        this.coBorrowerFirstName = coBorrowerFirstName;
    }

    public String getCoBorrowerLastName() {
        return coBorrowerLastName;
    }

    public void setCoBorrowerLastName(String coBorrowerLastName) {
        this.coBorrowerLastName = coBorrowerLastName;
    }

    public String getCoBorrowerPersonalNumber() {
        return coBorrowerPersonalNumber;
    }

    public void setCoBorrowerPersonalNumber(String coBorrowerPersonalNumber) {
        this.coBorrowerPersonalNumber = coBorrowerPersonalNumber;
    }

    public boolean isCertification() {
        return certification;
    }

    public void setCertification(boolean certification) {
        this.certification = certification;
    }
}
