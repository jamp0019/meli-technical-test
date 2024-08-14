package com.meli.proxy;

import com.meli.proxy.service.impl.resolver.ProxyClientAddressAndPathResolver;
import com.meli.proxy.service.impl.resolver.ProxyClientAddressResolver;
import com.meli.proxy.service.impl.resolver.ProxyClientPathResolver;
import com.meli.proxy.service.impl.resolver.ProxyClientTokenResolver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.http.server.reactive.MockServerHttpRequest;
import org.springframework.mock.web.server.MockServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.InetSocketAddress;

@ExtendWith(MockitoExtension.class)
public class ProxyClientResolverTest {

    @InjectMocks
    private ProxyClientAddressResolver proxyClientAddressResolver;

    @InjectMocks
    private ProxyClientPathResolver proxyClientPathResolver;

    @InjectMocks
    private ProxyClientAddressAndPathResolver proxyClientAddressAndPathResolver;

    @InjectMocks
    private ProxyClientTokenResolver proxyClientTokenResolver;

    @Test
    void setProxyClientAddressResolver(){

        Mono<String> response = proxyClientAddressResolver.resolve(MockServerWebExchange.from(
                MockServerHttpRequest
                        .get("/api1-service/getData")
                        .remoteAddress(new InetSocketAddress(8080))));
        Assertions.assertNotNull(response.block());

    }

    @Test
    void setProxyClientPathResolver(){

        Mono<String> response = proxyClientPathResolver.resolve(MockServerWebExchange.from(
                MockServerHttpRequest
                        .get("/api1-service/getData")
                        .contextPath("/api1-service/getData")));
        Assertions.assertNotNull(response.block());

    }

    @Test
    void setProxyClientAddressAndPathResolver(){
        Mono<String> response = proxyClientAddressAndPathResolver.resolve(MockServerWebExchange.from(
                MockServerHttpRequest
                        .get("/api1-service/getData")
                        .contextPath("/api1-service/getData")
                        .remoteAddress(new InetSocketAddress(8080))));
        Assertions.assertNotNull(response.block());
    }

    @Test
    void setProxyClientTokenResolver(){
        Mono<String> response = proxyClientTokenResolver.resolve(MockServerWebExchange.from(
                MockServerHttpRequest
                        .get("/api1-service/getData")
                        .header("Authorization","Bearer eyJhbGciOiJSUzI1N")));
        Assertions.assertNotNull(response.block());
    }

}
