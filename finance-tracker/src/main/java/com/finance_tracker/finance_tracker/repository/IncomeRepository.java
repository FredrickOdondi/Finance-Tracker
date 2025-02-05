package com.finance_tracker.finance_tracker.repository;

import com.finance_tracker.finance_tracker.model.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface IncomeRepository extends JpaRepository<Income, Long> {
    Optional<Income> findByUserId(Long id);
    // Handles the data in the Income table
}
