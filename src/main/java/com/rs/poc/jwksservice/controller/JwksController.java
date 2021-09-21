package com.rs.poc.jwksservice.controller;

import com.rs.poc.jwksservice.model.Decoded;
import com.rs.poc.jwksservice.model.Encoded;
import com.rs.poc.jwksservice.model.Keys;
import com.rs.poc.jwksservice.model.PrivateKey;
import com.rs.poc.jwksservice.service.JwksService;
import com.rs.poc.jwksservice.utils.Constants;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static com.rs.poc.jwksservice.utils.Constants.ID_PATH;
import static org.slf4j.LoggerFactory.getLogger;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(Constants.RESTV1)
public class JwksController {

    private static final Logger logger = getLogger(JwksController.class);

    @Autowired
    private JwksService service;

    @GetMapping
    public Keys jwks() {
        logger.debug("Getting Jwks list");
        return service.getKeys();
    }

    @PostMapping
    public PrivateKey generate() {
        logger.debug("generating a new key pair");
        return service.generateKey();
    }

    @PostMapping(path = Constants.ENCODE, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public Encoded encode(@RequestBody Decoded decoded) {
        return service.encode(decoded);
    }

    @PostMapping(path = Constants.DECODE, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public Decoded decode(@RequestBody Encoded encoded) {
        return service.decode(encoded);
    }

    @DeleteMapping(ID_PATH)
    public void delete(@PathVariable String id) {
        logger.debug("about to delete kid: {}", id);
        service.delete(id);
    }
}
