package com.example.microservice.api_gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		//リクエストの転送ルールを定義
		return builder.routes().route("currency-exchange",p -> p.path("/currency-exchange/**").uri("lb://CURRENCY-EXCHANGE-SERVICE"))
				.route("currency-conversion",p -> p.path("/currency-conversion/**").uri("lb://CURRENCY-CONVERSION-SERVICE")).build();
	}

}
