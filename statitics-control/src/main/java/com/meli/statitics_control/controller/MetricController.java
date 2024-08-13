package com.meli.statitics_control.controller;

import com.meli.statitics_control.model.Metric;
import com.meli.statitics_control.service.IRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/metric-service")
public class MetricController {

    @Autowired
    private IRedisService iRedisService;

    @GetMapping(value = "/findAll/{pageNumber}/{pageSize}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findAllMetrics(@RequestParam String listName, @PathVariable int pageNumber, @PathVariable int pageSize){
        List<Metric> metricList = iRedisService.findAllMetrics(listName, pageNumber, pageSize);
        return ResponseEntity.ok().body(metricList);
    }

}
