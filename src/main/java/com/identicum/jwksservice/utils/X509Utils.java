package com.identicum.jwksservice.utils;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.jwk.JWK;
import org.bouncycastle.jce.X509Principal;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.x509.X509V3CertificateGenerator;

import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.Security;
import java.security.SignatureException;
import java.security.cert.X509Certificate;
import java.util.Date;

import static java.lang.System.currentTimeMillis;
import static java.math.BigInteger.valueOf;

public class X509Utils {

    static {
        // adds the Bouncy castle provider to java security
        Security.addProvider(new BouncyCastleProvider());
    }
    @SuppressWarnings("deprecation")
    public static JWK createCertificate(KeyPair keyPair, String dn) {
        try {
            X509Certificate cert;
            X509V3CertificateGenerator v3CertGen =  new X509V3CertificateGenerator();
            v3CertGen.setSerialNumber(valueOf(currentTimeMillis()));
            v3CertGen.setIssuerDN(new X509Principal(dn));
            v3CertGen.setNotBefore(new Date(currentTimeMillis() - 1000L * 60 * 60 ));
            v3CertGen.setNotAfter(new Date(currentTimeMillis() + (1000L * 60 * 60 * 24 * 365)));
            v3CertGen.setSubjectDN(new X509Principal(dn));
            v3CertGen.setPublicKey(keyPair.getPublic());
            v3CertGen.setSignatureAlgorithm("SHA256WithRSA");
            cert = v3CertGen.generateX509Certificate(keyPair.getPrivate());
            return JWK.parse(cert);
        } catch (JOSEException | SignatureException | InvalidKeyException e) {
            throw new RuntimeException(e);
        }
    }
}