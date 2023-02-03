package com.mortagecalc.money.controller;

import com.mortagecalc.money.model.Calculation;
import com.mortagecalc.money.service.CalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/calculation")
@CrossOrigin
public class CalculationController {


    /**
     * This below is because I ran into som personal time constraints
     */
    private List<Calculation> db = List.of(
            new Calculation("Juha",1000,5,2),
            new Calculation("Karvinen",4356,1.27,6),
            new Calculation("Claes Månsson", 1300.55,8.67,2),
            new Calculation("Clarencé Andersson",2000,6,4)
    );

    public ArrayList<Calculation> db2 = new ArrayList<>();

    @Autowired
    private CalculationService calculationService;

    @RequestMapping(value = "/add")
    public String add(@RequestParam String userName,
                      @RequestParam double totalLoan,
                      @RequestParam double annualInterest,
                      @RequestParam int annualLoanTime){
        db2.add(new Calculation(userName,totalLoan,annualInterest,annualLoanTime));
        //calculationService.saveCalculation(calculation);
        return "New Calculation added";
    }

    @GetMapping("/examples")
    public List<Calculation> get() {
        return db;
        //return studentService.getAllStudents(); //If i had the time to implement the database :3
    }

    @GetMapping("calculations")
    public List<Calculation> getDb() {
        return db2;
    }
}
