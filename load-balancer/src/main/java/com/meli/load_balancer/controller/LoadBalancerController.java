package com.meli.load_balancer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

@RestController
public class LoadBalancerController {

    @Autowired
    private WebClient.Builder webClientBuilder;

    @GetMapping("/test")
    public Mono<String> testLoadBalancer(@RequestHeader("Authorization") String authorization) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        if(!authorization.isEmpty()){
            headers.add("Authorization", authorization);
        }
        return webClientBuilder.build()
                .get()
                .uri("http://proxy/api1-service/getData")
                .headers(h -> h.addAll(headers))
                .retrieve()
                .bodyToMono(String.class)
                .onErrorResume(WebClientResponseException.class, ex -> {
                    if (ex.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR) {
                        return Mono.just("Internal Server Error: " + ex.getMessage());
                    } else {
                        return Mono.error(ex);
                    }
                })
                .onErrorResume(Exception.class, ex -> Mono.just("An unexpected error occurred: " + ex.getMessage()));
    }
    /*@GetMapping("/invoke")
    public String invokeGateway() {
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject("http://proxy-gateway/api1-service/getData", String.class);
        return "Response from gateway: " + response;
    }
*/
}
