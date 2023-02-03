package com.mortagecalc.money.service;

import com.mortagecalc.money.model.Calculation;

import java.util.List;

public interface CalculationService {
    public Calculation saveCalculation(Calculation calculation);
    public List<Calculation> getAllCalculations();
}
