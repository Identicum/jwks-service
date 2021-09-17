package com.rs.poc.jwksservice.model;


import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Setter
@Getter
public class Decoded {

    private String kid;
    private Map<String, Object> claims;
}
