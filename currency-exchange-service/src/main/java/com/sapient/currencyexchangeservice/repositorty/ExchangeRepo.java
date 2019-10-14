package com.sapient.currencyexchangeservice.repositorty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sapient.currencyexchangeservice.model.Exchange;

@Repository
public interface ExchangeRepo extends JpaRepository<Exchange, Long> {

	
	Exchange findByFromAndTo(String from,String to);
}
