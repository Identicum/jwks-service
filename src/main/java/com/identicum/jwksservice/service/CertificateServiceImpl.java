package com.identicum.jwksservice.service;

import com.identicum.jwksservice.model.CertificateRequest;
import com.identicum.jwksservice.model.Keys;
import com.identicum.jwksservice.utils.X509Utils;
import com.nimbusds.jose.jwk.JWK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.KeyPair;
import java.util.HashMap;
import java.util.Map;

import static java.lang.String.format;
import static java.util.stream.Collectors.toList;

@Service
public class CertificateServiceImpl implements CertificateService{

    private Map<String, JWK> certificates = new HashMap();

    @Autowired
    private JwksService jwksService;

    @Override
    public Keys getCertificates() {
        Keys jwks = new Keys();
        jwks.setKeys(certificates.values().stream().map(jwt -> jwt.toPublicJWK().toJSONObject()).collect(toList()));
        return jwks;
    }

    @Override
    public Map<String, Object> generateCertificate(CertificateRequest request) {
        String kid = request.getKid();
        KeyPair keyPair = jwksService.getKeyPairByKid(kid);
        JWK cert = X509Utils.createCertificate(keyPair, request.getDn());
        certificates.put(kid, cert);
        return cert.toPublicJWK().toJSONObject();
    }

    @Override
    public void delete(String id) {
        if(certificates.remove(id) == null){
            throw new RuntimeException(format("kid: %s does not exist"));
        }
    }
}
