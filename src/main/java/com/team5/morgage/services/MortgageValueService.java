package com.team5.morgage.services;

import com.team5.morgage.exceptions.MortgageNotFoundException;
import com.team5.morgage.models.MortgageValue;
import com.team5.morgage.repositories.MortgageValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MortgageValueService {

    @Autowired
    private final MortgageValueRepository mortgageValueRepository;

    public MortgageValueService(MortgageValueRepository mortgageValueRepository) {
        this.mortgageValueRepository = mortgageValueRepository;
    }

    public MortgageValue getMortgageById(Long mortgageId) {
        return mortgageValueRepository
                .findById(mortgageId)
                .orElseThrow(() ->
                        new MortgageNotFoundException("Mortgage with id: " + mortgageId + " does not exist"));
    }

    public MortgageValue createMortgage(MortgageValue mortgageValue) {
        return mortgageValueRepository.save(mortgageValue);
    }

    public MortgageValue updateMortgage(MortgageValue mortgageValue) {
        MortgageValue updateMortgage = getMortgageById(mortgageValue.getId());

        if (mortgageValue.getSpecialNumber() != 0) {
            updateMortgage.setSpecialNumber(mortgageValue.getSpecialNumber());
        }
        if (mortgageValue.getManagementFee() != 0) {
            updateMortgage.setManagementFee(mortgageValue.getManagementFee());
        }

        return mortgageValueRepository.save(updateMortgage);
    }

    public void delete(Long mortgageId) {
        mortgageValueRepository.delete(getMortgageById(mortgageId));
    }
}
