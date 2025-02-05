package com.finance_tracker.finance_tracker.repository;

import com.finance_tracker.finance_tracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UserRepository extends JpaRepository<User, Long> {
    //Handles the data in the User table
}
