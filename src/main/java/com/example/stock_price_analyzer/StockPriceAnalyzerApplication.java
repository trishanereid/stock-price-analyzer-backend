package com.example.stock_price_analyzer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class StockPriceAnalyzerApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockPriceAnalyzerApplication.class, args);
	}

}
