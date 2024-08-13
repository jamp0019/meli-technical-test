package com.meli.api2.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/api2-service")
public class ApiController {
    @GetMapping(value = "/getData", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getApiInfo(){
        log.info("Response since API2");
        return ResponseEntity.ok().body("Response from api2");
    }
}
