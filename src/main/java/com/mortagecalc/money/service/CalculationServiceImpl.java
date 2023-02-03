package com.mortagecalc.money.service;

import com.mortagecalc.money.model.Calculation;
import com.mortagecalc.money.repository.CalculationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculationServiceImpl implements CalculationService {
    @Autowired
    private CalculationRepository calculationRepository;
    @Override
    public Calculation saveCalculation(Calculation calculation) {
        return calculationRepository.save(calculation);
    }

    @Override
    public List<Calculation> getAllCalculations() {
        return calculationRepository.findAll();
    }
}
