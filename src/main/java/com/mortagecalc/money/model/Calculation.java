package com.mortagecalc.money.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.concurrent.atomic.AtomicInteger;

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
    private double monthlyPayment;

    private static final int MONTHS_PER_YEAR = 12;
    private static final int TO_PERCENTAGE_PER_MONTH = 1200;

    static AtomicInteger nextId = new AtomicInteger();

    public Calculation() {

    }

    public double calculateMonthly(int numberPayment, double monthlyInterest, double totalLoan) {
        double temp = 1;
        for (int i = 0; i < numberPayment; i++) {
            temp *= (1+monthlyInterest);
        }
        return totalLoan * (monthlyInterest * temp)/(temp-1);
    }

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

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }
}
