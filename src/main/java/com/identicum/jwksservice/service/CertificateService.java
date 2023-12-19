package com.identicum.jwksservice.service;

import com.identicum.jwksservice.model.CertificateRequest;
import com.identicum.jwksservice.model.Keys;

import java.util.Map;

public interface CertificateService {

    Keys getCertificates();

    Map<String, Object> generateCertificate(CertificateRequest request);

    void delete(String id);
}
