package com.mortagecalc.money.controller;

import com.mortagecalc.money.model.Calculation;
import com.mortagecalc.money.service.CalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the controller for the Calculations.
 * Perhaps not entirely up to the standard for the normal file-to-assignment structure but at least it works.
 */
@RestController
@RequestMapping("/calculation")
@CrossOrigin
public class CalculationController {


    /**
     * This is the examples database that always shows in the frontend
     * Not used for the calculatiosn done by the users.
     * Also, this approach was chosen since of personal time constraints
     */
    private final List<Calculation> db = List.of(
            new Calculation("Juha",1000,5,2),
            new Calculation("Karvinen",4356,1.27,6),
            new Calculation("Claes Månsson", 1300.55,8.67,2),
            new Calculation("Clarencé Andersson",2000,6,4)
    );
    /**
     * Temporary database that resets for every re-run
     * This solution works for the purpose that the calculator resets after every restart
     */
    public ArrayList<Calculation> db2 = new ArrayList<>();

    /**
     * @param userName Username entered by the user
     * @param totalLoan The total loan amount entered by the user
     * @param annualInterest The annual interest entered by the user
     * @param annualLoanTime The loan time in years entered by the user
     * @return Returns simple string that states that a new calculation has been added
     */
    @RequestMapping(value = "/add")
    public String add(@RequestParam String userName,
                      @RequestParam double totalLoan,
                      @RequestParam double annualInterest,
                      @RequestParam int annualLoanTime){
        db2.add(new Calculation(userName,totalLoan,annualInterest,annualLoanTime));
        //calculationService.saveCalculation(calculation);
        return "New Calculation added: "+userName;
    }
    /**
     * Used when database is implemented
     */
    @Autowired
    private CalculationService calculationService;

    /**
     * @return returns the examples database
     */
    @GetMapping("/examples")
    public List<Calculation> get() {
        return db;
        //return studentService.getAllStudents(); //If i had the time to implement the database :3
    }

    /**
     * @return Returns the database that contains the calculations that the customer does
     */
    @GetMapping("calculations")
    public List<Calculation> getDb() {
        return db2;
    }
}
