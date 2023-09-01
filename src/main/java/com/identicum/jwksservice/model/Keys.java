package com.identicum.jwksservice.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class Keys {

    private List<Map<String, Object>> keys;
}
