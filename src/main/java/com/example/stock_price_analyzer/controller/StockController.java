package com.example.stock_price_analyzer.controller;

import com.example.stock_price_analyzer.client.StockApiClient;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class StockController {
    private final StockApiClient stockApiClient;
    private final ObjectMapper objectMapper;

    @GetMapping("/fetch/{symbol}")
    public String fetch(@PathVariable String symbol) throws IOException, InterruptedException {
        return stockApiClient.fetchStockData(symbol);
    }

    @GetMapping("/retrieve-by-date-range/{symbol}/{startDate}/{endDate}")
    public void retrieveDataByDateRange(@PathVariable String symbol, String startDate, String endDate) throws IOException, InterruptedException {
        stockApiClient.retrieveStockDataByDateRange(symbol, startDate, endDate);
    }
}