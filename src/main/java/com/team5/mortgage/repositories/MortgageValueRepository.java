package com.team5.mortgage.repositories;

import com.team5.mortgage.models.MortgageValue;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MortgageValueRepository extends CrudRepository<MortgageValue, Long> {
}
