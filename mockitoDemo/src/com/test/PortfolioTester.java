package com.test;

import java.util.ArrayList;
import java.util.List;

import com.model.Stock;
import com.service.Portfolio;
import com.service.StockService;
import static org.mockito.Mockito.*;

public class PortfolioTester {
	   Portfolio portfolio;	
	   StockService stockService;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PortfolioTester p=new PortfolioTester();
		p.setUp();
		System.out.println(p.testMarketValue()?"pass":"fail");
		System.out.println("ok");
		System.out.println("methods use in mockito");

	}

	private void setUp() {
		// TODO Auto-generated method stub
		portfolio=new Portfolio();
		
		stockService=mock(StockService.class);
		portfolio.setStockService(stockService);
		
	}
	public boolean testMarketValue() {
	      List<Stock> stocks = new ArrayList<Stock>();
	      Stock googleStock = new Stock("1","Google", 10);
	      Stock microsoftStock = new Stock("2","Microsoft",100);
	      
	      stocks.add(googleStock);
	      stocks.add(microsoftStock);
	      
	      //add stocks to the portfolio
	      portfolio.setStocks(stocks);
	      
	      when(stockService.getPrice(googleStock)).thenReturn(50.00);
	      when(stockService.getPrice(microsoftStock)).thenReturn(1000.00);
	      double marketValue = portfolio.getMarketValue();		
	      return marketValue == 100500.0;
	}

}
