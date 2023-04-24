package com.team5.mortgage.controllers;

import com.team5.mortgage.models.MortgageValue;
import com.team5.mortgage.services.MortgageValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/mortgage")
@RestController
public class MortgageValueController {

    @Autowired
    private final MortgageValueService mortgageValueService;

    public MortgageValueController(MortgageValueService mortgageValueService) {
        this.mortgageValueService = mortgageValueService;
    }

    @GetMapping("/{mortgageId}")
    public MortgageValue getMortgageById(@PathVariable Long mortgageId) {
        return mortgageValueService.getMortgageById(mortgageId);
    }

    @PostMapping("/create")
    public MortgageValue createMortgage(@RequestBody MortgageValue mortgageValue) {
        return mortgageValueService.createMortgage(mortgageValue);
    }

    @PutMapping("/update")
    public MortgageValue updateMortgage(@RequestBody MortgageValue mortgageValue) {
        return mortgageValueService.updateMortgage(mortgageValue);
    }

    @DeleteMapping("/delete/{mortgageId}")
    public void delete(@PathVariable Long mortgageId) {
        mortgageValueService.delete(mortgageId);
    }
}
