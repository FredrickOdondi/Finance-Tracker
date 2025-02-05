package com.finance_tracker.finance_tracker.service;

import java.math.BigDecimal;
import java.util.Map;

public interface CurrencyService {

    Map<String, Double> fetchExchangeRates();

    double convertCurrency(double amount, String fromCurrency, String toCurrency);
    BigDecimal convertToBaseCurrency(BigDecimal amount, BigDecimal currency, String baseCurrency);
}