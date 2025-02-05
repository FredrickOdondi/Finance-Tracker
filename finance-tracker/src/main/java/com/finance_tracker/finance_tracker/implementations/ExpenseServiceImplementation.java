package com.finance_tracker.finance_tracker.implementations;

import com.finance_tracker.finance_tracker.model.Expense;
import com.finance_tracker.finance_tracker.repository.ExpenseRepository;
import com.finance_tracker.finance_tracker.service.CurrencyService;
import com.finance_tracker.finance_tracker.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public abstract class ExpenseServiceImplementation implements ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private CurrencyService currencyService; // Injecting CurrencyService

    private String userBaseCurrency = "USD"; // Set user's base currency (this can be dynamic)

    // Create new Expense record
    @Override
    public Expense addExpense(Expense expense) {
        if (expense.getForeignAmount() != null && expense.getAmount() != null) {
            // Convert the foreign amount to user's base currency
            BigDecimal convertedAmount = currencyService.convertToBaseCurrency(
                    expense.getForeignAmount(),
                    expense.getAmount(),
                    userBaseCurrency
            );
            expense.setAmount(convertedAmount); // Set the converted amount
        }

        return expenseRepository.save(expense); // Save the expense with the converted amount
    }

    // Displays a list of all expenses
    @Override
    public Optional<Expense> getExpenseByUserId(Long id) {
        return expenseRepository.findByUserId(id);
    }

    @Override
    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }

    @Override
    public Optional<Expense> updateExpense(Long id, Expense expense) {
        Optional<Expense> existingExpenseOptional = expenseRepository.findById(id);
        if (existingExpenseOptional.isPresent()) {
            Expense existingExpense = existingExpenseOptional.get();

            // Update the fields of the existing expense record

            existingExpense.setDate(expense.getDate());
            existingExpense.setCategory(expense.getCategory());
            existingExpense.setDescription(expense.getDescription());

            // You can add other fields here as necessary

            expenseRepository.save(existingExpense); // Save the updated record
            return Optional.of(existingExpense);
        }
        return Optional.empty(); // Return empty if the expense record does not exist
    }
}