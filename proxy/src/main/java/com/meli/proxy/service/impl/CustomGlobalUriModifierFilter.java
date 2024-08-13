package com.meli.proxy.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.URI;

import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.GATEWAY_REQUEST_URL_ATTR;

@Component
@Slf4j
public class CustomGlobalUriModifierFilter {

    /*@Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        HttpHeaders headers = exchange.getRequest().getHeaders();
        URI originalUri = exchange.getRequest().getURI();
        String newUri = originalUri.toString().replace("LAPTOP-745SM1N2", "localhost");
        URI modifiedUri = URI.create(newUri);
        ServerHttpRequest mutatedRequest = exchange.getRequest().mutate().uri(modifiedUri).build();
        exchange.getAttributes().put(GATEWAY_REQUEST_URL_ATTR, mutatedRequest.getURI());
        return chain.filter(exchange.mutate().request(mutatedRequest).build());

    }

    @Override
    public int getOrder() {
        return -1;
    }*/
}


