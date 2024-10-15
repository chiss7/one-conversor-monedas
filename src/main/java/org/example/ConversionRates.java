package org.example;

import java.util.HashMap;
import java.util.Map;

public class ConversionRates {
    private String result;
    private String baseCode;
    private Map<String, Double> conversionRates;

    public ConversionRates() {
    }

    public ConversionRates(String result, String baseCode, Map<String, Double> conversionRates) {
        this.result = result;
        this.baseCode = baseCode;
        this.conversionRates = conversionRates;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getBaseCode() {
        return baseCode;
    }

    public void setBaseCode(String baseCode) {
        this.baseCode = baseCode;
    }

    public Map<String, Double> getConversionRates() {
        return conversionRates;
    }

    public void setConversionRates(Map<String, Double> conversionRates) {
        this.conversionRates = conversionRates;
    }

    @Override
    public String toString() {
        return "ConversionRates{" +
                "result='" + result + '\'' +
                ", baseCode='" + baseCode + '\'' +
                ", conversionRates=" + conversionRates +
                '}';
    }
}
