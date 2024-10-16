package org.example;

import java.util.Map;

public record ConversionRatesRequest(
        String result,
        String baseCode,
        Map<String, Double> conversionRates
) {
}
