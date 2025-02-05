package com.finance_tracker.finance_tracker.repository;

import com.finance_tracker.finance_tracker.model.Savings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface SavingsRepository extends JpaRepository<Savings,Long> {
    Optional<Savings> findByUserId(Long id);
    //Handles data in the Savings table
}
