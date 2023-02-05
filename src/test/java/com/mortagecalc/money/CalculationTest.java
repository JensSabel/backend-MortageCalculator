package com.mortagecalc.money;

import com.mortagecalc.money.model.Calculation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests the logic for performing the calculations to monthly payment
 * #Fixed issue with decimal converting not working properly in my code
 */
public class CalculationTest {
    private static final int MONTHS_PER_YEAR = 12;
    private static final int TO_PERCENTAGE_PER_MONTH = 1200;

    /**
     * Test calculation using easy numbers
     * Tests input: 10000€ loan in 15 years with 6% annual interest
     */
    @Test
    void normalIntCalculation() {
        Calculation calculation = new Calculation();
        double loan = 10000;
        int time = 15;
        double interets = 6.0;
        int monthtlyT = time*MONTHS_PER_YEAR;
        double monthlyI = interets/TO_PERCENTAGE_PER_MONTH;
        String expected = "84.39";
        String actual = calculation.calculateMonthly(monthtlyT,monthlyI,loan);
        System.out.println(actual);
        assertEquals(expected,actual);
    }

    /**
     * Test calculation using two decimals
     * Test input: 1456.25 € in 10 years with 8.23% annual interest
     */
    @Test
    void twoDecimalCalculation() {
        Calculation calculation = new Calculation();
        double loan = 1456.25;
        int time = 10;
        double interest = 8.23;
        int monthlyT = time*MONTHS_PER_YEAR;
        double monthlyI = interest/TO_PERCENTAGE_PER_MONTH;
        String expected = "17.85";
        String actual = calculation.calculateMonthly(monthlyT,monthlyI,loan);
        assertEquals(expected,actual);
    }

    /**
     * Test calculation using more decimals
     * Test input: 10000.123456 € in 25 years with 9.12345 % interest
     */
    @Test
    void moreDecimalCalculation() {
        Calculation calculation = new Calculation();
        double loan = 10000.123456;
        int time = 25;
        double interest = 9.12345;
        int monthlyT = time*MONTHS_PER_YEAR;
        double monthlyI = interest/TO_PERCENTAGE_PER_MONTH;
        String expected = "84.77";
        String actual = calculation.calculateMonthly(monthlyT,monthlyI,loan);
        assertEquals(expected, actual);
    }
}
