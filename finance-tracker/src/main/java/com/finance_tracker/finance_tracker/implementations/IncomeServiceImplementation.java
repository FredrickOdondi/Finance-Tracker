package com.finance_tracker.finance_tracker.implementations;

import com.finance_tracker.finance_tracker.model.Income;
import com.finance_tracker.finance_tracker.repository.IncomeRepository;
import com.finance_tracker.finance_tracker.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public abstract class IncomeServiceImplementation implements IncomeService { // Removed 'abstract'

    @Autowired
    private IncomeRepository incomeRepository;

    // Create a new Income record
    @Override
    public Income addIncome(Income income) {
        return incomeRepository.save(income);
    }

    // Get all Income records by User ID
    @Override
    public Optional<Income> getIncomesByUser(Long id) {
        return incomeRepository.findByUserId(id); // Replace with a method to find incomes by user ID
    }

    // Delete income record
    @Override
    public void deleteIncome(Long id) {
        if (incomeRepository.existsById(id)) { // Check if the income exists
            incomeRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("No income found with the provided ID: " + id);
        }
    }

    // Update an existing income record
    @Override
    public Optional<Income> updateIncome(Long id, Income income) {
        Optional<Income> existingIncomeOptional = incomeRepository.findByUserId(id);
        if (existingIncomeOptional.isPresent()) {
            Income existingIncome = existingIncomeOptional.get();

            // Update the fields of the existing income record
            existingIncome.setAmount(income.getAmount());
            existingIncome.setDate(income.getDate());
            existingIncome.setSource(income.getSource());

            // Save the updated record
            return Optional.of(incomeRepository.save(existingIncome)); // Return the updated income
        }
        return Optional.empty(); // Return empty if the income record does not exist
    }
}