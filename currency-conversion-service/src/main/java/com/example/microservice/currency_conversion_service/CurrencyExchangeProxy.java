package com.example.microservice.currency_conversion_service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//Eurrekaサーバーが自動でロードバランシングしてくれるので、URIを指定する必要ない。
//@FeignClient(name="currency-exchange-service",url="http://localhost:8000")
@FeignClient(name="currency-exchange-service")
public interface CurrencyExchangeProxy {

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversion retrieveExchangeValue(@PathVariable String from, @PathVariable String to);




}
