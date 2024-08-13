package com.meli.proxy.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;


@Component("ProxyClientAddressAndPathResolver")
@Slf4j
public class ProxyClientAddressAndPathResolver implements KeyResolver {

    @Override
    public Mono<String> resolve(ServerWebExchange exchange) {
        log.info("URI:");
        log.info(exchange.getRequest().getURI().toString());
        return Mono.just(exchange.getRequest().getURI().toString());
    }

}
