package com.example.stock_price_analyzer.client;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Service
@Configuration
@RequiredArgsConstructor
public class StockApiClient {
    private static final String API_KEY = "demo";
    private static final String URl = "https://www.alphavantage.co/query?";
    private final HttpClient httpClient;


    @Cacheable(value = "stocks", key = "#symbol")
    public String fetchStockData(String symbol) throws IOException, InterruptedException {
        String api_URL = URl+"function=TIME_SERIES_MONTHLY&symbol="+symbol+"&apikey="+API_KEY;

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(api_URL)).build();
        HttpResponse<String> response = httpClient.send(request,HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200){
            return response.body();
        }else {
            throw new IOException("API request failed: "+response.statusCode());
        }
    }

    public void retrieveStockDataByDateRange(
            String symbol,
            String startDate,
            String endDate
    ) {
        //TODO
    }
}