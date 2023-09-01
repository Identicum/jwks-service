package com.identicum.jwksservice.model;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Encoded {

    private String kid;
    private String jwt;
}
