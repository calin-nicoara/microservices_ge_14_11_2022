## Curl operations

Getting token with **password** grant:
```
curl  -XPOST -k http://localhost/realms/spring-boot-test/protocol/openid-connect/token  -u clientId:secret -d grant_type=password  -d username=user -d password=pass
```

Getting token with **client credentials** grant:

```
curl  -XPOST -k http://localhost/realms/spring-boot-test/protocol/openid-connect/token -u clientId:secret -d grant_type=client_credentials 
```

Authorization Grant Type code
```
http://localhost/realms/spring-boot-test/protocol/openid-connect/auth?grant_type=authorization_code&response_type=code&client_id=clientId
```

```
curl  -XPOST -k http://localhost/realms/spring-boot-test/protocol/openid-connect/token  -u clientId:secret -d grant_type=authorization_code -d code=JeGFTC
```
