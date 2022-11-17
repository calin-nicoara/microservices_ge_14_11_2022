# Keycloack



Docker image: https://hub.docker.com/r/bitnami/keycloak
Bitnami docker-compose: ``curl -LO https://raw.githubusercontent.com/bitnami/bitnami-docker-keycloak/master/docker-compose.yml``

## Using

* Post: http://localhost:8199/auth/realms/SpringBootTest/protocol/openid-connect/token
Example of curl:
```
curl --location --request POST 'http://localhost/realms/spring-boot-test/protocol/openid-connect/token' \
--header 'Content-Type: application/x-www-form-urlencoded' \
--data-urlencode 'client_id=ui-app' \
--data-urlencode 'username=calin.nicoara' \
--data-urlencode 'password=password' \
--data-urlencode 'grant_type=password'
```


### Steps to take
* Go to http://localhost and login
* "Add realm" on the 
