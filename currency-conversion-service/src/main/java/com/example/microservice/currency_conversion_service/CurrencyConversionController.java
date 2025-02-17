package com.example.microservice.currency_conversion_service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConversionController {

	@Autowired
	private CurrencyExchangeProxy proxy;

	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion culculateCurrencyConversion(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {


		CurrencyConversion currencyConversion = proxy.retrieveExchangeValue(from, to);

		return new CurrencyConversion(currencyConversion.getId(), from, to,
				currencyConversion.getConversionMultiple(), quantity,
				quantity.multiply(currencyConversion.getConversionMultiple()), currencyConversion.getEnvironment());

	}

}
