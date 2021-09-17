package com.rs.poc.jwksservice.service;


import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSHeader.Builder;
import com.nimbusds.jose.JWSObject;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.Payload;
import com.nimbusds.jose.jwk.JWK;
import com.rs.poc.jwksservice.model.Decoded;
import com.rs.poc.jwksservice.model.Encoded;
import com.rs.poc.jwksservice.model.Keys;
import com.rs.poc.jwksservice.model.PrivateKey;
import com.rs.poc.jwksservice.utils.JwkUtils;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import static com.nimbusds.jose.JWSAlgorithm.RS256;
import static com.rs.poc.jwksservice.utils.JwkUtils.getSigner;
import static java.lang.String.format;
import static java.util.Base64.getEncoder;
import static java.util.UUID.randomUUID;
import static java.util.stream.Collectors.toList;
import static org.slf4j.LoggerFactory.getLogger;

@Service
public class JwksServiceImpl implements JwksService {

    private static final Logger logger = getLogger(JwksServiceImpl.class);
    private Map<String, JWK> keys = new HashMap();

    @Override
    public Keys getKeys() {
        Keys jwks = new Keys();
        jwks.setKeys(keys.values().stream().map(jwt -> jwt.toPublicJWK().toJSONObject()).collect(toList()));
        return jwks;
    }

    @Override
    public PrivateKey generateKey() {
        logger.debug("generating key...");
        String kid = randomUUID().toString();
        JWK jwk = JwkUtils.generateKey(kid);
        keys.put(kid, jwk);
        PrivateKey privKey = new PrivateKey();
        privKey.setKid(kid);
        privKey.setRsaPrivateKey(getPrivateKey(jwk));
        return privKey;
    }

    @Override
    public Encoded encode(Decoded decoded) {
        try {
            String kid = decoded.getKid();
            JWSSigner signer = getSigner(keys, kid);
            JWSObject jwsObject = new JWSObject(new Builder(RS256).keyID(kid).build(), new Payload(decoded.getClaims()));
            jwsObject.sign(signer);
            Encoded response = new Encoded();
            response.setKid(kid);
            response.setJwt(jwsObject.serialize());
            return response;
        } catch (JOSEException e) {
            throw new RuntimeException("Error encoding");
        }
    }

    @Override
    public Decoded decode(Encoded encoded) {
        try {
            String kid = encoded.getKid();
            JWSObject jwsObject = JWSObject.parse(encoded.getJwt());
            JWSVerifier verifier = JwkUtils.getVerifier(keys, kid);

            Decoded response = new Decoded();
            response.setKid(kid);
            if(jwsObject.verify(verifier)){
                response.setClaims(jwsObject.getPayload().toJSONObject());
            } else {
                Map<String,Object> error = new HashMap<>();
                error.put("Error", "Cant validate signature with given kid");
                response.setClaims(error);
            }
            return response;
        } catch (ParseException | JOSEException e) {
            throw new RuntimeException("Error decoding");
        }
    }

    private String getPrivateKey(JWK jwk) {
        try {
            return format("-----BEGIN PRIVATE KEY-----\\n%s\\n-----END PRIVATE KEY-----", getEncoder().encodeToString(jwk.toRSAKey().toRSAPrivateKey().getEncoded()));
        } catch (JOSEException e) {
            throw new RuntimeException("Error recovering private key");
        }
    }
}
