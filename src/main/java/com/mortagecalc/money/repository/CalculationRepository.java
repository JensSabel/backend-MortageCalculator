package com.mortagecalc.money.repository;

import com.mortagecalc.money.model.Calculation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalculationRepository extends JpaRepository<Calculation, Calculation> {

}
