package com.meli.proxy.util;

import com.meli.proxy.model.Metric;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class Util implements IUtil{
    @Override
    public Metric toMetricObject(String requestId, Date startDate, String path, long petitionDuration, int statusCode, Date finishDate) {
        return Metric.builder()
                .requestId(requestId)
                .startDate(startDate)
                .path(path)
                .petitionDuration(petitionDuration)
                .statusCode(statusCode)
                .finishDate(finishDate)
                .build();
    }
}
