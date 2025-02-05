package com.finance_tracker.finance_tracker.implementations;

import com.finance_tracker.finance_tracker.model.User;
import com.finance_tracker.finance_tracker.repository.UserRepository;
import com.finance_tracker.finance_tracker.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; // Import for password hashing
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepository; // Injects UserRepository

    @Autowired
    private BCryptPasswordEncoder passwordEncoder; // Enable password encoding

    // Register a new user
    @Override
    @Transactional
    public User registerUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }

        // Hashing the password before saving
        String hashedPassword = passwordEncoder.encode(user.getPassword());

        // Set username, email, and hashed password
        user.setUsername(user.getUsername());
        user.setPassword(hashedPassword);
        user.setEmail(user.getEmail());

        return userRepository.save(user);
    }
}