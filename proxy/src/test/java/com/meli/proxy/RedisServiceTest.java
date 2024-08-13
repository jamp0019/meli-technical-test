package com.meli.proxy;

import com.meli.proxy.model.Metric;
import com.meli.proxy.service.impl.RedisService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.redis.core.ReactiveListOperations;
import reactor.core.publisher.Mono;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RedisServiceTest {

    @InjectMocks
    private RedisService redisService;

    @Mock
    private ReactiveListOperations<String, Object> reactiveListOps;

    private Metric metric;

    @BeforeEach
    void before(){
        LoadData loadData = new LoadData();
        metric = loadData.buildMetric();
    }

    @Test
    void saveObject(){
        when(reactiveListOps.leftPush(metric.getPath(), metric)).thenReturn(Mono.just(1L));
        Mono<Long> response = redisService.saveObject(metric);
        Assertions.assertEquals(response.block(), 1L);

    }

}
