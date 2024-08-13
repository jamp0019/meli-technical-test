package com.meli.proxy;

import com.meli.proxy.model.Metric;

import java.util.Date;

public class LoadData {
    public DummyRequest buildRequest(){
        return DummyRequest.builder()
                .HostAddress("192.0.0.5")
                .build();
    }

    public Metric buildMetric(){
        return Metric.builder()
                .requestId("1100")
                .path("/api1-service/getData")
                .finishDate(new Date())
                .startDate(new Date())
                .petitionDuration(12)
                .statusCode(200)
                .build();
    }
}
