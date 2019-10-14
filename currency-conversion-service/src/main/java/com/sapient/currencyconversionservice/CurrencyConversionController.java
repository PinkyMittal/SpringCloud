package com.sapient.currencyconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sapient.currencyconversionservice.model.ConversionBean;



@RestController
public class CurrencyConversionController {
	
	
	RestTemplate restTemp = new RestTemplate();
	

	
	@GetMapping("/currency-conversion/from/{from}/to/{to}/qty/{qty}")
	public ConversionBean convertCurrency(@PathVariable String from,@PathVariable String to,@PathVariable BigDecimal qty ) 
	{
		//Exchange exchangeValue = new Exchange(1000l,from,to,BigDecimal.valueOf(65l));
		//Integer port = Integer.parseInt(env.getProperty("local.server.port"));
		//ConversionBean exchangeValue = repo.findByFromAndTo(from, to);
		//exchangeValue.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		//System.out.println("port========="+port);
		
		Map<String,String> UriVar = new HashMap();
		UriVar.put("from", from);
		UriVar.put("to", to);
		ResponseEntity<ConversionBean> responseEntity = restTemp.getForEntity("http://localhost:8000/currency-exhange/from/{from}/to/{to}", ConversionBean.class,UriVar);
		ConversionBean response = responseEntity.getBody();
		return new ConversionBean(response.getId(),from, to, response.getRate(), qty, qty.multiply(response.getRate()), 0);
				
		
	}
	
}
