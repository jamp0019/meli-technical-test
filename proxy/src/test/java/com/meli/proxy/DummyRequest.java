package com.meli.proxy;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DummyRequest {
    private String HostAddress;
}
