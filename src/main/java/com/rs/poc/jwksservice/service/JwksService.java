package com.rs.poc.jwksservice.service;

import com.rs.poc.jwksservice.model.Encoded;
import com.rs.poc.jwksservice.model.Decoded;
import com.rs.poc.jwksservice.model.Keys;
import com.rs.poc.jwksservice.model.PrivateKey;

public interface JwksService {

    Keys getKeys();

    PrivateKey generateKey();

    Encoded encode(Decoded decoded);

    Decoded decode(Encoded encoded);
}
