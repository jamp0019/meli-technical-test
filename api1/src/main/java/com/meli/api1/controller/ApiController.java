package com.meli.api1.controller;

import com.meli.api1.model.CustomResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api1-service")
@Slf4j
public class ApiController {

    @Value("${server.instance}")
    private String serverInstance;

    @GetMapping(value = "/getData", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getApiInfo(){

        log.info("Response since API1 - {}", serverInstance);
        return ResponseEntity.ok().body(CustomResponse.builder()
                        .message("Response since API1")
                        .instance(Integer.valueOf(serverInstance))
                        .build());
    }

}
