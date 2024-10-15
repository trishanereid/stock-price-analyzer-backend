package com.example.stock_price_analyzer.controller;

import com.example.stock_price_analyzer.client.StockApiClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class StockController {
    private final StockApiClient stockApiClient;

    @GetMapping("/fetch/{symbol}")
    public String fetch(@PathVariable String symbol) throws IOException, InterruptedException {
        return stockApiClient.fetchStockData(symbol);
    }
}