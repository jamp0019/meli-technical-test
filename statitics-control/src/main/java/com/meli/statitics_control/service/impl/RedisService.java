package com.meli.statitics_control.service.impl;

import com.meli.statitics_control.model.Metric;
import com.meli.statitics_control.service.IRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RedisService implements IRedisService {

    @Autowired
    private RedisTemplate<String, Metric> redisTemplate;

    @Override
    public List<Metric> findAllMetrics(String listName, int pageNumber, int pageSize) {
        int start = (pageNumber - 1) * pageSize;
        int end = start + pageSize - 1;
        return redisTemplate.opsForList().range(listName, start, end);
    }
}
