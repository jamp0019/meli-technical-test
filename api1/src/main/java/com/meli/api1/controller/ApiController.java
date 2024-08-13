package com.meli.api1.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api1-service")
@Slf4j
public class ApiController {
    @GetMapping(value = "/getData", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getApiInfo(){
        log.info("Response since API1");
        return ResponseEntity.ok().body("Response from api1");
    }

}
