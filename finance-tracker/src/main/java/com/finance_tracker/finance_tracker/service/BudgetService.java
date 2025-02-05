package com.finance_tracker.finance_tracker.service;

import com.finance_tracker.finance_tracker.model.Budget;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public interface BudgetService {
    Budget addBudget(Budget budget); // adds a new budget to the budget table
    Optional<Budget> getBudgetByUserId(Long id); // displays a list of budget based on the user id
    void deleteBudget(Long id);// deletes budget from database
    Budget updateBudget(Budget budget); // updates the current budget

    Optional<Budget> updateBudget(Long id, Budget budget);
}
