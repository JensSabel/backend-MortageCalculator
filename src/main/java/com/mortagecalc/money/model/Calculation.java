package com.mortagecalc.money.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.text.DecimalFormat;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Main class for the calculation itself.
 * Also, the class where the monthly calculations are done.
 * Basic getters and setters also generated.
 */
@Entity
public class Calculation {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    private String userName;
    private double totalLoan;
    private int annualLoanTime; //Total years of payment
    private int monthlyLoanTime; //Total months of payment
    private double annualInterest;
    private double monthlyInterest;
    private String monthlyPayment;

    private static final int MONTHS_PER_YEAR = 12;
    private static final int TO_PERCENTAGE_PER_MONTH = 1200;

    //Used for setting the ID
    static AtomicInteger nextId = new AtomicInteger();

    public Calculation() {

    }

    /**
     * @param numberPayment Amount of months to pay back the loan
     * @param monthlyInterest Monthly interest calculated from annual interest divided by 1200
     * @param totalLoan Total amount of the laon
     * @return Returns a string value that has been rounded using the decimal formatter library
     */
    public String calculateMonthly(int numberPayment, double monthlyInterest, double totalLoan) {
        double temp = 1;
        DecimalFormat df = new DecimalFormat("0.00");
        for (int i = 0; i < numberPayment; i++) {
            temp *= (1+monthlyInterest);
        }
        return df.format(totalLoan * (monthlyInterest * temp)/(temp-1));
    }

    /**
     * Performs some basic calculations and sets it per calculation
     * @param userName User name
     * @param totalLoan Total amount of loan
     * @param annualInterest The annual interest in percentage
     * @param annualLoanTime The loan term in years
     */
    public Calculation(String userName, double totalLoan, double annualInterest, int annualLoanTime) {

        this.id = nextId.incrementAndGet();
        this.userName = userName;
        this.totalLoan = totalLoan;
        this.annualLoanTime = annualLoanTime;
        this.monthlyLoanTime = annualLoanTime * MONTHS_PER_YEAR;
        this.annualInterest = annualInterest;
        this.monthlyInterest = annualInterest / TO_PERCENTAGE_PER_MONTH;
        this.monthlyPayment = calculateMonthly(this.monthlyLoanTime, this.monthlyInterest, totalLoan);
    }

    /**
     * Basic getters and setters below
     */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public double getTotalLoan() {
        return totalLoan;
    }

    public void setTotalLoan(double totalLoan) {
        this.totalLoan = totalLoan;
    }

    public double getAnnualLoanTime() {
        return annualLoanTime;
    }

    public void setAnnualLoanTime(int annualLoan) {
        this.annualLoanTime = annualLoan;
    }

    public double getMonthlyLoanTime() {
        return monthlyLoanTime;
    }

    public void setMonthlyLoanTime(int monthlyLoan) {
        this.monthlyLoanTime = monthlyLoan;
    }

    public double getAnnualInterest() {
        return annualInterest;
    }

    public void setAnnualInterest(double annualInterest) {
        this.annualInterest = annualInterest;
    }

    public double getMonthlyInterest() {
        return monthlyInterest;
    }

    public void setMonthlyInterest(double monthlyInterest) {
        this.monthlyInterest = monthlyInterest;
    }

    public String getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(String monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }
}
