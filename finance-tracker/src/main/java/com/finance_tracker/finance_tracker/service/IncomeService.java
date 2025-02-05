package com.finance_tracker.finance_tracker.service;

import com.finance_tracker.finance_tracker.model.Income;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public interface IncomeService {
    Income addIncome(Income income); // Add a new income record

    // Get Income by User ID, assuming you want that as a list of incomes for a specific user
    Optional<Income> getIncomesByUser(Long userId);

    Optional<Income> getIncomesByUserId(Long id); // Get all incomes for a user
    void deleteIncome(Long id); // Delete an income record
    Income updateIncome(Income income); // Update an existing income record

    Optional<Income> updateIncome(Long id, Income income);
}
