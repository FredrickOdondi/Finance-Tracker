package com.finance_tracker.finance_tracker.repository;

import com.finance_tracker.finance_tracker.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    Optional<Expense> findByUserId(Long id);
}
