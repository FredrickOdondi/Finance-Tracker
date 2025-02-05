package com.finance_tracker.finance_tracker.implementations;

import com.finance_tracker.finance_tracker.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@Service
public abstract class CurrencyServiceImplementation implements CurrencyService {
    private final RestTemplate restTemplate;

    @Autowired
    public CurrencyServiceImplementation(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private static final String EXCHANGE_RATE_API_URL = "https://api.currencylayer.com/live?access_key=e2a60c2548fe23b1feb9ea4317702cb3";

    @Override
    public Map<String, Double> fetchExchangeRates() {
        // Adjust the URL to use the appropriate parameter
        Object baseCurrency = new Object();
        String url = UriComponentsBuilder.fromHttpUrl(EXCHANGE_RATE_API_URL)
                .queryParam("currencies", baseCurrency)
                .toUriString();

        ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);
        if (response.getBody() != null && response.getBody().containsKey("quotes")) {
            return (Map<String, Double>) response.getBody().get("quotes");
        }
        throw new IllegalArgumentException("Invalid response from currency API");
    }

    @Override
    public double convertCurrency(double amount, String fromCurrency, String toCurrency) {
        Map<String, Double> rates = fetchExchangeRates();
        Double rate = rates.get(toCurrency);
        if (rate == null) {
            throw new IllegalArgumentException("Currency not found: " + toCurrency);
        }
        return amount * rate;
    }
}