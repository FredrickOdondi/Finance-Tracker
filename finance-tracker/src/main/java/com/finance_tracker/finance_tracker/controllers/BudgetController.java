package com.finance_tracker.finance_tracker.controllers;

import com.finance_tracker.finance_tracker.model.Budget;
import com.finance_tracker.finance_tracker.model.Income;
import com.finance_tracker.finance_tracker.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/budget")

public class BudgetController {
    @Autowired
    private BudgetService budgetService;
    // Add a new Budget record
    @PostMapping
    public ResponseEntity<Budget> addBudget(@RequestBody Budget budget) {
        Budget savedBudget = budgetService.addBudget(budget);
        return new ResponseEntity<>(savedBudget, HttpStatus.CREATED);
    }
}
