package com.meli.proxy.service.impl.resolver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component("ProxyClientPathResolver")
@Slf4j
public class ProxyClientPathResolver implements KeyResolver {

    @Override
    public Mono<String> resolve(ServerWebExchange exchange) {
        log.info("Destination path:");
        log.info(String.valueOf(exchange.getRequest().getPath()));
        return Mono.just(exchange.getRequest().getPath().toString());
    }

}
