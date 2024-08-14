package com.meli.api2.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/api2-service")
public class ApiController {

    @Value("${server.instance}")
    private String serverInstance;

    @GetMapping(value = "/getData", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getApiInfo(){
        String response = "Response since API2 - "+serverInstance;
        log.info(response);
        return ResponseEntity.ok().body(response);
    }
}
