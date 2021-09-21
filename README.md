# jwks-service


### Run

#### cmd
- prerequisites:
    - maven 3.6.x +
    - JDK 1.8 +

```
mvn spring-boot:run
```

#### Docker
- prerequisites:
    - Docker 19.03+
```
docker run -p 80:8080 roundservices/jwks-service
```

### Operations

#### GetJwks

- Request
```
GET /restv1/jwks HTTP/1.1
Host: es-jwks-service.rstest.biz
```
- Response
```
{
    "keys": [
        {
            "kty": "RSA",
            "e": "AQAB",
            "use": "sig",
            "kid": "cded5e7c-ac25-42e7-871c-8b20c1209c00",
            "alg": "RS256",
            "n": "jVqBOFQOQKPyDdHBj4cLHcjaLoTFDaiV-jGJa3KTEOyPe5hRqZs7M0hvarsduf460n18-TzxFxnbWs2pr8KuMQK4LXungEj_-gwzPQR9Ak05v36Sn_vISfSSE5i4LyIkKO3NYn3_eHvvg41bepIgLEpg8ZdV0ykCu-SsEcck3IdwfQLLmDz9cbLTI-NJvejIfinOnAx7qsOiWQ5LZU3LcSk7toR50XicalXIySeVWiznPZ_X5oOKzfpn47pWSUTurmdSdaBE5oOjUxAiPM9xhCYXBN257lc5_uQ4djMkvgGXe9vMEQ9pJ4mA5wzXeFp1yUQL1rUn49wJqtC8zS3Yvw"
        }
    ]
}
```
	
#### Create a jwks
- Request
```
POST /restv1/jwks HTTP/1.1
Host: es-jwks-service.rstest.biz
```
- Response
```
{
    "kid": "cded5e7c-ac25-42e7-871c-8b20c1209c00",
    "rsaPrivateKey": "-----BEGIN PRIVATE KEY-----\\nMIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCNWoE4VA5Ao/IN0cGPhwsdyNouhMUNqJX6MYlrcpMQ7I97mFGpmzszSG9qux25/jrSfXz5PPEXGdtazamvwq4xArgte6eASP/6DDM9BH0CTTm/fpKf+8hJ9JITmLgvIiQo7c1iff94e++DjVt6kiAsSmDxl1XTKQK75KwRxyTch3B9AsuYPP1xstMj40m96Mh+Kc6cDHuqw6JZDktlTctxKTu2hHnReJxqVcjJJ5VaLOc9n9fmg4rN+mfjulZJRO6uZ1J1oETmg6NTECI8z3GEJhcE3bnuVzn+5Dh2MyS+AZd728wRD2kniYDnDNd4WnXJRAvWtSfj3Amq0LzNLdi/AgMBAAECggEAeLFsYEI1ITBa/z24feqarUXQNaQb9Pubg1NEuL/Nnse+A5QdNipbNACHUaSPTz4pz4xiZxWH7WegijnMx0v9G8/snrlUXg72sfQ008a/TnXN9xoF7CA59hujlqPxsB0ArwnNMmnO9nssGTFbiJ64ZdjkSaQkHfaIZRJtcYiOitSwkj3NZp9d1NFt9O0B+4/AXptlsQUc+WZ4ZJVFSqRyQYUU4wYov0EhCZnKecLiXHLpiqmDeWvbANHL8RoGzRVAiGS43nbhoZim8ySLdyE1OIKiMAGeT9zmq+HzSY5csf/yuuNhpv/uBfbrKMOxCDVrLpALXAXXch9LZJ5MqLAhIQKBgQD76K+PNtI22g/v7juHGRD0/e0y4DtQrBLuIZP1kxh17646aC3fh3NlUpw/0d7MTTw/mTJ0SH9ZeYHOq0YnAGb+wiUWeAx6JZq3ioSf5ZPhFpdtZ+yBI2E5/02vRikbGcH8O/Cel2WYjZAQ8L2PNc/lJrj7K1bShV+EwMm63ihISQKBgQCPpi8F3VQHCG/5lpLpwaEaHefhbNeXUOmD+X10s6rzFRiPuI13KCq++yDKDMoBm6bMYV+SirkB7BQKJGqF5mNlklRdAaZrnyoVNIE7MauEvrv4AUK8OMUzvIk6EoFps+2acygVuIhw7rb6UQZ4QCtfxDC2RRZh7DP5KWisyoBoxwKBgQDGegr418TBGwa7kASu6P0HSpp9H1cctLclkKc3MfJv2ax4sGSUXfB5wKEDV6QnbCMwKNAr9oMASFASObhIOnTr/KOkFGogQ0innCfqo8Pj8RzWQq+BABM20wSuOKViiOTii4eGLNsLW15LOqLgFxH6BoxwuTDrJdKgkhVfenJaoQKBgAoS6XFL2Dy2BsRGHv9tqNKgDkbszyG5dubedEHe57osXJCXrLQSiQzjp6UDyJbcR5JFseIhAGB2IeGkNCQ3x/izjl8HYphhjR33lKiGDzU7+wqla/yvLoU2T5lW+uRizeLq+ICtdEQXOZXMYNvGBESvCYt+xNcRLYPnt4OGoAK5AoGBALtVDRK7EmQw1wysXljKpiMYR6ThCBayxPInq9mX0zJ8lR8/k+swlO3ebJmjf5DjXwh1Z02NtLvM6HtvKYbFkCzvZP6F9wUl68FIeIv3KNwPOgW1nh8cbgfL8j8wQ7Fy93coQvoeeOYEBMUz45D/DO0Z1I+QsME+F1TlLalXl2gp\\n-----END PRIVATE KEY-----"
}
```

#### Create a JWT signed by specific kid

- Request
    - kid: of the jwks which wants for jwt generation
    - claims: a JSONObject which will be the payload on generated JWT
```
POST /restv1/jwks/encode HTTP/1.1
Host: es-jwks-service.rstest.biz
Content-Type: application/json

{
    "kid": "c8b2bf1b-0aea-4ae4-8a08-29b09f54d9ba",
    "claims": {
        "sub": "dev1",
        "aud": "mobile_demo",
        "op": "act",
        "iss": "TS",
        "exp": 1628033819,
        "iat": 1628032019,
        "jti": "78cb56fa-6157-43e3-96fe-aac763e83712",
        "o": "OrgA"
    }
}
```
- Response
```
{
    "kid": "cded5e7c-ac25-42e7-871c-8b20c1209c00",
    "jwt": "eyJraWQiOiJjZGVkNWU3Yy1hYzI1LTQyZTctODcxYy04YjIwYzEyMDljMDAiLCJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJkZXYxIiwiYXVkIjoibW9iaWxlX2RlbW8iLCJvcCI6ImFjdCIsImlzcyI6IlRTIiwiZXhwIjoxNjI4MDMzODE5LCJpYXQiOjE2MjgwMzIwMTksImp0aSI6Ijc4Y2I1NmZhLTYxNTctNDNlMy05NmZlLWFhYzc2M2U4MzcxMiIsIm8iOiJPcmdBIn0.bgZelgoJFrwago3D53luFX43exLBPJx_odO4OXB_hsq8P2bWo-YezsRhZMDVGOwH3gU76f_oh4KeMpnPBN6qGQXzyprfC5NYtUsbzrIkljutQQvs3sEyVxdXWUsgDflKoQ2ZpZUMdgqQGoCKQAD_x_iuw1TxPxz1aX7LbdOU1vFZLLuNMxhbHjQm3HHae0l3RLV925MZEH91LKzgDVyUs7ABtiyXJdaoKxFIynOTXChl3fduSpXXSWO-hHpdGf3WR0xHKpSKcScek4t4KC7beswR6ryJm4B1nBBII8nfjVmY007jhGY0RfDIuzEAL9hHr03GaZNnP_SvBUbkdoz4gg"
}
```
		
#### Validates a JWT signed by specific kid

- Request
    - kid: of the jwks which wants for jwt validation
    - jwt: a string who representates the jwt to be validated
```
POST /restv1/jwks/decode HTTP/1.1
Host: es-jwks-service.rstest.biz
Content-Type: application/json

{
    "kid": "c8b2bf1b-0aea-4ae4-8a08-29b09f54d9ba",
    "jwt": "eyJraWQiOiJjZGVkNWU3Yy1hYzI1LTQyZTctODcxYy04YjIwYzEyMDljMDAiLCJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJkZXYxIiwiYXVkIjoibW9iaWxlX2RlbW8iLCJvcCI6ImFjdCIsImlzcyI6IlRTIiwiZXhwIjoxNjI4MDMzODE5LCJpYXQiOjE2MjgwMzIwMTksImp0aSI6Ijc4Y2I1NmZhLTYxNTctNDNlMy05NmZlLWFhYzc2M2U4MzcxMiIsIm8iOiJPcmdBIn0.bgZelgoJFrwago3D53luFX43exLBPJx_odO4OXB_hsq8P2bWo-YezsRhZMDVGOwH3gU76f_oh4KeMpnPBN6qGQXzyprfC5NYtUsbzrIkljutQQvs3sEyVxdXWUsgDflKoQ2ZpZUMdgqQGoCKQAD_x_iuw1TxPxz1aX7LbdOU1vFZLLuNMxhbHjQm3HHae0l3RLV925MZEH91LKzgDVyUs7ABtiyXJdaoKxFIynOTXChl3fduSpXXSWO-hHpdGf3WR0xHKpSKcScek4t4KC7beswR6ryJm4B1nBBII8nfjVmY007jhGY0RfDIuzEAL9hHr03GaZNnP_SvBUbkdoz4gg"
}
```
- Response
```
{
    "kid": "cded5e7c-ac25-42e7-871c-8b20c1209c00",
    "claims": {
            "sub": "dev1",
            "aud": "mobile_demo",
            "op": "act",
            "iss": "TS",
            "exp": 1628033819,
            "iat": 1628032019,
            "jti": "78cb56fa-6157-43e3-96fe-aac763e83712",
            "o": "OrgA"
        }
}
```

#### Deletes a Cert based on kid value:
- Request
    - kid-value: replace for the certificate kid that wants to remove
```
DELETE /restv1/jwks/{{kid-value}}
Host: es-jwks-service.rstest.biz
```
- Response: `HTTP 204 no-content`
			
### Developer notes:
- Only generates `RS256` certs
- JwkUtils class contains Algorithms and Cert type logic (If you want to expand it ;-)