package com.identicum.jwksservice.service;

import com.identicum.jwksservice.model.Decoded;
import com.identicum.jwksservice.model.Encoded;
import com.identicum.jwksservice.model.Keys;
import com.identicum.jwksservice.model.PrivateKey;

public interface JwksService {

    Keys getKeys();

    PrivateKey generateKey();

    Encoded encode(Decoded decoded);

    Decoded decode(Encoded encoded);

    void delete(String id);
}
