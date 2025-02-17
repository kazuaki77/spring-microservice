package com.example.microservice.currency_exchange_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.microservice.currency_exchange_service.bean.CurrentExchange;
import com.example.microservice.currency_exchange_service.mapper.CurrentExchangeMapper;

@Service
public class CurrentExchangeService {

	private final CurrentExchangeMapper mapper;

	@Autowired
	public CurrentExchangeService(CurrentExchangeMapper mapper) {
		this.mapper = mapper;
	}

	public List<CurrentExchange> findAll() {
		return mapper.findAll();

	}

	public CurrentExchange findById(Long id) {
		return mapper.findById(id);
	}

	public CurrentExchange findByFromAndTo(String currencyFrom, String currencyTo) {
		return mapper.findByFromAndTo(currencyFrom, currencyTo);
	}
}
