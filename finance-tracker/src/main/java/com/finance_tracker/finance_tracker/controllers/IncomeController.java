package com.finance_tracker.finance_tracker.controllers;

import com.finance_tracker.finance_tracker.model.Income;
import com.finance_tracker.finance_tracker.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/incomes")
public class IncomeController {
    @Autowired
    private IncomeService incomeService;
    // Add a new income record
    @PostMapping
    public ResponseEntity<Income> addIncome(@RequestBody Income income) {
        Income savedIncome = incomeService.addIncome(income);
        return new ResponseEntity<>(savedIncome, HttpStatus.CREATED);
    }

    // Get all incomes for a specific user
    @GetMapping("/user/{userId}")
    public ResponseEntity<Optional<Income>> getIncomesByUser(@PathVariable Long userId) {
        Optional<Income> incomes = incomeService.getIncomesByUser(userId);
        if (incomes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(incomes, HttpStatus.OK);
    }

    // Delete an income record by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIncome(@PathVariable Long id) {
        incomeService.deleteIncome(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
