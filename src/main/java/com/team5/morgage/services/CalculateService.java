package com.team5.morgage.services;

import com.team5.morgage.exceptions.MortgageNotFoundException;
import com.team5.morgage.models.MortgageValue;
import com.team5.morgage.models.SecondResponse;
import com.team5.morgage.repositories.MortgageValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculateService {

    @Autowired
    private MortgageValueRepository mortgageValueRepository;

    public float firstForm(FirstRequest request) {
        MortgageValue mortgageValue = mortgageValueRepository.findById(1L).orElseThrow(() -> new MortgageNotFoundException("There are no mortgage values present"));

        // ToDo: validations

        return mortgageValue.getSpecialNumber() * request.getNetIncome();
    }

    public SecondResponse secondForm(SecondRequest request) {
        MortgageValue mortgageValue = mortgageValueRepository.findById(1L)
                .orElseThrow(() -> new MortgageNotFoundException("There are no mortgage values present"));
        SecondResponse secondResponse = new SecondResponse();

        // ToDo: validations

        float newInterestRate = request.getInterestRate() + mortgageValue.getManagementFee();
        float interestPaidInOneYear = newInterestRate * request.getMortgageAmount();
        float interestPaidDuringWholePeriod = interestPaidInOneYear * request.getMortgageTerm();

        secondResponse.setTotalPayableAmount(interestPaidDuringWholePeriod + request.getMortgageAmount());
        // ToDo: add '12' to DB mortgage_value table as new column with name "?"
        secondResponse.setMonthlyPayment(secondResponse.getTotalPayableAmount() / request.getMortgageTerm() / 12);
        secondResponse.setInterestCost(interestPaidDuringWholePeriod);

        return secondResponse;
    }

    public static class FirstRequest {
        private boolean isJustMe;
        private float netIncome;
        private int familyMembers;
        private float monthlyObligation;

        public boolean isJustMe() {
            return isJustMe;
        }

        public float getNetIncome() {
            return netIncome;
        }

        public int getFamilyMembers() {
            return familyMembers;
        }

        public float getMonthlyObligation() {
            return monthlyObligation;
        }
    }

    public static class SecondRequest {
        private float homePrice;
        private float mortgageAmount;
        private float downPayment;
        private float interestRate;
        private int mortgageTerm;

        public float getHomePrice() {
            return homePrice;
        }

        public float getMortgageAmount() {
            return mortgageAmount;
        }

        public float getDownPayment() {
            return downPayment;
        }

        public float getInterestRate() {
            return interestRate;
        }

        public int getMortgageTerm() {
            return mortgageTerm;
        }
    }

}
