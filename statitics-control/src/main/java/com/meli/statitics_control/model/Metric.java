package com.meli.statitics_control.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

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
