package com.meli.proxy.service.impl;

import com.meli.proxy.model.Metric;
import com.meli.proxy.service.IRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class RedisService implements IRedisService {

    @Autowired
    private ReactiveRedisTemplate<String, Object> reactiveRedisTemplate;

    @Override
    public Mono<Long> saveObject(Metric object) {
        return reactiveRedisTemplate
                .opsForList()
                .leftPush(object.getPath(), object);
    }
}
