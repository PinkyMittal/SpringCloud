package com.sapient.currencyexchangeservice;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.currencyexchangeservice.model.Exchange;
import com.sapient.currencyexchangeservice.repositorty.ExchangeRepo;

@RestController
public class CurrencyExchangeController {
	
	@Autowired
	private Environment env;
	
	@Autowired
	private ExchangeRepo repo;

	@GetMapping("/currency-exhange/from/{from}/to/{to}")
	public Exchange getConversionRate(@PathVariable String from,@PathVariable String to ) 
	{
		//Exchange exchangeValue = new Exchange(1000l,from,to,BigDecimal.valueOf(65l));
		//Integer port = Integer.parseInt(env.getProperty("local.server.port"));
		Exchange exchangeValue = repo.findByFromAndTo(from, to);
		exchangeValue.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		//System.out.println("port========="+port);
				
		return exchangeValue;
	}
	
	
	@PostMapping("/create")
	public void saveConversionRate(@RequestBody Exchange exchange) 
	{
		repo.save(exchange);
			
	}
}
