package com.identicum.jwksservice.controller;

import com.identicum.jwksservice.model.CertificateRequest;
import com.identicum.jwksservice.model.Keys;
import com.identicum.jwksservice.service.CertificateService;
import com.identicum.jwksservice.utils.Constants;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static com.identicum.jwksservice.utils.Constants.ID_PATH;
import static org.slf4j.LoggerFactory.getLogger;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(Constants.CERT_ENDPOINT)
public class CertificateController {

    private static final Logger logger = getLogger(CertificateController.class);

    @Autowired
    private CertificateService service;

    @GetMapping
    public Keys certificates() {
        logger.debug("Getting Jwks list");
        return service.getCertificates();
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public Map<String, Object> generate(@RequestBody CertificateRequest request) {
        logger.debug("Generating new certificate");
        return service.generateCertificate(request);
    }
    @DeleteMapping(ID_PATH)
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable String id) {
        logger.debug("About to delete certificate kid: {}", id);
        service.delete(id);
    }
}
