package com.finance_tracker.finance_tracker.service;

import com.finance_tracker.finance_tracker.model.Expense;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public interface ExpenseService {
    Expense addExpense(Expense expense);// Create a new expense
    Optional<Expense> getExpenseByUserId(Long id); // Gets all Expenses for a specific user
    void  deleteExpense(Long id);// Deletes an expense record
    Expense updateExpense(Expense expense);

    Optional<Expense> updateIncome(Long id, Expense expense);

    Optional<Expense> updateExpense(Long id, Expense expense);
}
