package com.meli.statitics_control.service;

import com.meli.statitics_control.model.Metric;

import java.util.List;

public interface IRedisService {
    List<Metric> findAllMetrics(String listName, int pageNumber, int pageSize);
}
