package com.finance_tracker.finance_tracker.service;

import com.finance_tracker.finance_tracker.model.User;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service

public interface UserService {
    @Transactional
    User registerUser(User user);// Register a new user

}
