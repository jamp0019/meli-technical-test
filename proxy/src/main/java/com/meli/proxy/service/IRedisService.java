package com.meli.proxy.service;

import com.meli.proxy.model.Metric;
import reactor.core.publisher.Mono;

public interface IRedisService {
    Mono<Long> saveObject(Metric object);
}
