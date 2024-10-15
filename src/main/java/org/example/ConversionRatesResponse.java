package org.example;

import java.util.Map;

public record ConversionRatesResponse(
        String result,
        String baseCode,
        Map<String, Double> conversionRates
) {
}
