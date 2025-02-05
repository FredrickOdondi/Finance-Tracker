package com.finance_tracker.finance_tracker.implementations;

import com.finance_tracker.finance_tracker.model.Savings;
import com.finance_tracker.finance_tracker.repository.SavingsRepository;
import com.finance_tracker.finance_tracker.service.SavingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SavingsServiceImplementation implements SavingsService { // Removed 'abstract'

    @Autowired
    private SavingsRepository savingsRepository;

    @Override
    public Savings addNewSavings(Savings savings) {
        // Optional: Validate 'savings' object here
        return savingsRepository.save(savings);
    }

    @Override
    public Optional<Savings> getSavingByUserId(Long id) {
        return savingsRepository.findByUserId(id);
    }

    @Override
    public void deleteSaving(Long id) {
        if (savingsRepository.existsById(id)) { // Check if the id exists
            savingsRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("No savings found with the provided ID: " + id); // Handle accordingly
        }
    }

    @Override
    public Savings updateSavings(Savings savings) {
        return null;
    }

    @Override
    public double calculateProgress(Long id, double savingsGoal) {
        return 0;
    }
}