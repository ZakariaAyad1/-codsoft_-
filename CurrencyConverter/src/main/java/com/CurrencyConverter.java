package com;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class CurrencyConverter {
    private static final String API_URL = "https://api.exchangerate-api.com/v4/latest/";

    public BigDecimal fetchExchangeRate(String baseCurrency, String targetCurrency) throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpGet request = new HttpGet(API_URL + baseCurrency);
        HttpResponse response = httpClient.execute(request);

        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        StringBuilder result = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            result.append(line);
        }

        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(result.toString());

        BigDecimal exchangeRate = node.get("rates").get(targetCurrency).decimalValue();

        return exchangeRate;
    }
}
