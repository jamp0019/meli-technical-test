package com.meli.proxy;

import com.meli.proxy.service.impl.CustomMetricsFilter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.handler.FilteringWebHandler;
import org.springframework.mock.http.server.reactive.MockServerHttpRequest;
import org.springframework.mock.web.server.MockServerWebExchange;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.InetSocketAddress;

@ExtendWith(MockitoExtension.class)
public class CustomMetricsFilterTest {

	@InjectMocks
	private CustomMetricsFilter customMetricsFilter;

	@Test
	void setCustomMetricsFilter(){

		GatewayFilterChain gatewayFilterChain = Mockito.mock(GatewayFilterChain.class);
		FilteringWebHandler filteringWebHandler = new FilteringWebHandler(null);
		filteringWebHandler.handle(MockServerWebExchange.from(
				MockServerHttpRequest
						.get("/api1-service/getData")
						.remoteAddress(new InetSocketAddress(8080))));



		gatewayFilterChain.filter(MockServerWebExchange.from(
				MockServerHttpRequest
						.get("/api1-service/getData")
						.remoteAddress(new InetSocketAddress(8080))));

		Mono<Void> response = customMetricsFilter.filter(MockServerWebExchange.from(
				MockServerHttpRequest
						.get("/api1-service/getData")
						.remoteAddress(new InetSocketAddress(8080))), gatewayFilterChain);
		Assertions.assertNotNull(response.block());

	}

}
