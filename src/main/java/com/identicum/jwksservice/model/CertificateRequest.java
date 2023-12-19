package com.identicum.jwksservice.model;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CertificateRequest {

    private String kid;
    private String dn;
}
