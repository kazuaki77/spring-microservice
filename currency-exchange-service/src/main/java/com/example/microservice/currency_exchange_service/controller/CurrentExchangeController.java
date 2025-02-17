package com.example.microservice.currency_exchange_service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservice.currency_exchange_service.bean.CurrentExchange;
import com.example.microservice.currency_exchange_service.service.CurrentExchangeService;

@RestController
public class CurrentExchangeController {

	private Logger logger = LoggerFactory.getLogger(CurrentExchangeController.class);

	@Autowired
	Environment environment;

	@Autowired
	CurrentExchangeService service;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrentExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {

		logger.info("retrieveExchangeValue called with {} to {}", from, to);

		CurrentExchange currentExchange = service.findByFromAndTo(from, to);

		String port = environment.getProperty("local.server.port");
		currentExchange.setEnvironment(port);
		return currentExchange;
	}

}
