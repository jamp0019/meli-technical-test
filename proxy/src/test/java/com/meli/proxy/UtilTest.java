package com.meli.proxy;

import com.meli.proxy.model.Metric;
import com.meli.proxy.util.Util;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

@ExtendWith(MockitoExtension.class)
public class UtilTest {

    @InjectMocks
    private Util util;


    @Test
    void toMetricObject(){
        Metric response = util.toMetricObject("1100",new Date(),"/api1-service/getData", 12, 200, new Date());
        Assertions.assertEquals(response.getPath(), "/api1-service/getData");
    }


}
