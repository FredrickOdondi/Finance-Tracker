package com.finance_tracker.finance_tracker.service;

import com.finance_tracker.finance_tracker.model.Savings;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public interface SavingsService {
    Savings addNewSavings(Savings savings); // create a new savings record in tha table
    Optional<Savings> getSavingByUserId(Long id); // Displays a list a savings
    void deleteSaving(Long id); // Delete a single savings record
    Savings updateSavings(Savings savings); // Updates the savings list

    double calculateProgress(Long id, double savingsGoal);

}
