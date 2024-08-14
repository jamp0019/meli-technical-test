package com.meli.proxy.service.impl.filter;

import com.meli.proxy.model.Metric;
import com.meli.proxy.service.IRedisService;
import com.meli.proxy.util.IUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import java.util.Date;

@Component
@Slf4j
public class CustomMetricsFilter implements GlobalFilter {

    @Autowired
    private IUtil iUtil;

    @Autowired
    private IRedisService iRedisService;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        long startTime = System.currentTimeMillis();
        Date startDate = new Date();

        return chain.filter(exchange).then(
                Mono.fromRunnable(() -> {
                    String requestId = exchange.getRequest().getId();
                    String path = exchange.getRequest().getURI().getPath();
                    long duration = System.currentTimeMillis() - startTime;
                    int statusCode = exchange.getResponse().getStatusCode().value();
                    Date finishDate = new Date();
                    log.info("request id {}", requestId);
                    log.info("start date {}", startDate);
                    log.info("path {}", path);
                    log.info("duration {}", duration);
                    log.info("status code {}", statusCode);
                    log.info("finish date {}", finishDate);
                    Metric metric = iUtil.toMetricObject(requestId, startDate, path, duration, statusCode, finishDate);
                    saveMetrics(metric);
                })
        );

    }
    public void saveMetrics(Metric metric){
        iRedisService.saveObject(metric);
    }

}
