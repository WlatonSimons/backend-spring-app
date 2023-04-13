package com.team5.morgage.controllers;

import com.team5.morgage.models.MortgageValue;
import com.team5.morgage.models.User;
import com.team5.morgage.services.MortgageValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MortgageValueController {

    @Autowired
    private MortgageValueService mortgageValueService;

    @GetMapping("/mortgage/{mortgageId}")
    public MortgageValue getMortgageById(@PathVariable Long mortgageId) {
        return mortgageValueService.getMortgageById(mortgageId);
    }

    @PostMapping("/mortgage/create")
    public MortgageValue createMortgage(@RequestBody MortgageValue mortgageValue) {
        return mortgageValueService.createMortgage(mortgageValue);
    }

    @PutMapping("/mortgage/update")
    public MortgageValue updateMortgage(@RequestBody MortgageValue mortgageValue) {
        return mortgageValueService.updateMortgage(mortgageValue);
    }

    @DeleteMapping("/mortgage/delete/{mortgageId}")
    public void delete(@PathVariable Long mortgageId) {
        mortgageValueService.delete(mortgageId);
    }
}
