package org.example;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class CurrencyConverter {
    private ConversionRates conversionRate;
    private final Map<String, ConversionRates> conversionRatesCache;

    public CurrencyConverter() {
        conversionRatesCache = new HashMap<>();
    }

    public void loadConversionRates(String baseCode) {
        if (isInCache(baseCode)) {
            System.out.println("Resultado obtenido de caché :D");
            this.conversionRate = conversionRatesCache.get(baseCode);
            return;
        }
        String url_str = "https://v6.exchangerate-api.com/v6/e5263eb334561b9f837af1ec/latest/" + baseCode;
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url_str))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                    .create();

            ConversionRatesRequest json_response = gson.fromJson(response.body(), ConversionRatesRequest.class);
            this.conversionRate = new ConversionRates(json_response.result(), json_response.baseCode(), json_response.conversionRates());
            this.conversionRatesCache.put(baseCode, this.conversionRate);
        } catch (InterruptedException | IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private boolean isInCache(String baseCode) {
        return this.conversionRatesCache.containsKey(baseCode);
    }

    public ConversionRates getConversionRate() {
        return this.conversionRate;
    }

    public Double convert(Double from, Double to) {
        return from * to;
    }
}
