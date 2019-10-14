package com.sapient.limitsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.limitsservice.bean.LimitConfiguration;

@RestController
public class LimitsConfigurationController {

	@Autowired
	private Configuration cfg;
	@GetMapping("/limits")
	public LimitConfiguration retrieveLimits() 
	{
		return new LimitConfiguration(cfg.getMax(),cfg.getMin());
	}
}
