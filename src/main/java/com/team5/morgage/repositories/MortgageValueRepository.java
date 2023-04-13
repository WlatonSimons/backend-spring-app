package com.team5.morgage.repositories;

import com.team5.morgage.models.MortgageValue;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MortgageValueRepository extends CrudRepository<MortgageValue, Long> {
}
