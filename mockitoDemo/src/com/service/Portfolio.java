package com.service;

import java.util.List;

import com.model.Stock;

public class Portfolio {
	private StockService stockService;
	private List<Stock>stocks;
	public StockService getStockService() {
		return stockService;
	}
	public void setStockService(StockService stockService) {
		this.stockService = stockService;
	}
	public List<Stock> getStocks() {
		return stocks;
	}
	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}
	
	public double getMarketValue() {
		double mv=0.0;
		for(Stock stc:stocks) {
			mv+= stockService.getPrice(stc)*stc.getQuantity();
		}
		return mv;
	}
	

}
