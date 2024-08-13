package com.meli.proxy.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Metric {

    private String requestId;
    private Date startDate;
    private String path;
    private long petitionDuration;
    private int statusCode;
    private Date finishDate;

}
