package com.finance_tracker.finance_tracker.implementations;

import com.finance_tracker.finance_tracker.model.Budget;
import com.finance_tracker.finance_tracker.repository.BudgetRepository;
import com.finance_tracker.finance_tracker.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public abstract class BudgetServiceImplementation implements BudgetService {
    @Autowired
    private BudgetRepository budgetRepository;


    @Override
    public Budget addBudget(Budget budget) {
        return budgetRepository.save(budget);
    }

    @Override
    public Optional<Budget> getBudgetByUserId(Long id) {
        return budgetRepository.findByUserId(id);
    }

    @Override
    public void deleteBudget(Long id) {
        budgetRepository.deleteById(id);

    }

    @Override
    public Optional<Budget> updateBudget(Long id, Budget budget) {
        Optional<Budget> existingBudgetOptional = budgetRepository.findById(id);
        if (existingBudgetOptional.isPresent()) {
            Budget existingBudget = existingBudgetOptional.get();

            // Update the fields of the existing income record
            existingBudget.setLimit(budget.getLimit());
            existingBudget.setCategory(budget.getCategory());
            existingBudget.setStartDate(budget.getStartDate());
            existingBudget.setEndDate(budget.getEndDate());

            // You can add other fields here as necessary

            budgetRepository.save(existingBudget); // Save the updated record
            return Optional.of(existingBudget);
        }
        return Optional.empty(); // Return empty if the income record does not exist
    }
}
