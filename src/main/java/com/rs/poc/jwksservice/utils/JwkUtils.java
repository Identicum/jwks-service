package com.rs.poc.jwksservice.utils;

import com.nimbusds.jose.Algorithm;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.crypto.RSASSASigner;
import com.nimbusds.jose.crypto.RSASSAVerifier;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.gen.RSAKeyGenerator;

import java.util.Map;

import static com.nimbusds.jose.jwk.KeyUse.SIGNATURE;

public class JwkUtils {

    public static JWK generateKey(String kid) {
        try{
            return new RSAKeyGenerator(2048).keyUse(SIGNATURE).keyID(kid).algorithm(Algorithm.parse("RS256")).generate();
        } catch (JOSEException e) {
            throw new RuntimeException("Error generating Key");
        }
    }

    public static RSASSASigner getSigner(Map<String,JWK> keys, String kid) throws JOSEException {
        return new RSASSASigner(keys.get(kid).toRSAKey());
    }

    public static RSASSAVerifier getVerifier(Map<String,JWK> keys, String kid) throws JOSEException {
        return new RSASSAVerifier(keys.get(kid).toRSAKey().toRSAPublicKey());
    }
}
