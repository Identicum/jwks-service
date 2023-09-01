package com.identicum.jwksservice.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PrivateKey {

    private String kid;
    private String rsaPrivateKey;
}
