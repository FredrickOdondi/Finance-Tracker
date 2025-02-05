package com.finance_tracker.finance_tracker.repository;

import com.finance_tracker.finance_tracker.model.Budget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface BudgetRepository extends JpaRepository<Budget, Long> {
    Optional<Budget> findByUserId(Long id);
    //Handles the data in the budget table
}
