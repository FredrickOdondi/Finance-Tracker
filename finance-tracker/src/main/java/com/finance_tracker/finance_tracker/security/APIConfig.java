package com.finance_tracker.finance_tracker.security;

import com.finance_tracker.finance_tracker.implementations.BudgetServiceImplementation;
import com.finance_tracker.finance_tracker.implementations.IncomeServiceImplementation;
import com.finance_tracker.finance_tracker.model.Budget;
import com.finance_tracker.finance_tracker.model.Income;
import com.finance_tracker.finance_tracker.service.BudgetService;
import com.finance_tracker.finance_tracker.service.IncomeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Configuration

public class APIConfig {
    @Bean// This annotation indicates that a method produces a bean that should be managed by the Spring container.
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    @Bean
    public BudgetService budgetService() {
        return new BudgetServiceImplementation() {
            @Override
            public Budget updateBudget(Budget budget) {
                return null;
            }
        }; // Adjust according to your actual implementation

    }
    @Bean
    public IncomeService incomeService() {
        return new IncomeServiceImplementation() {
            @Override
            public Optional<Income> getIncomesByUserId(Long id) {
                return Optional.empty();
            }

            @Override
            public Income updateIncome(Income income) {
                return null;
            }
        }; // Adjust this to your specific implementation
    }
}
