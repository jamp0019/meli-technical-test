package com.meli.proxy.util;

import com.meli.proxy.model.Metric;

import java.util.Date;

public interface IUtil {
    Metric toMetricObject(String requestId, Date startDate, String path, long petitionDuration, int statusCode, Date finishDate);

}
