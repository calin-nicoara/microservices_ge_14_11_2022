# Spring CLoud Config

Allows you to make a centralized application for configurations which are retrieve from many sources.

Docs:

- https://cloud.spring.io/spring-cloud-config/reference/html/
- https://spring.io/guides/gs/centralized-configuration/

## 1. Setup config server

Dependencies:
```
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-config-server</artifactId>
</dependency>
```
Example of configs:
```
server.port=8888

spring.cloud.config.server.git.uri=https://github.com/calin-nicoara/spring-cloud-config-test
spring.cloud.config.server.git.default-label=main

spring.cloud.config.server.git.username=calin-nicoara
spring.cloud.config.server.git.password=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
```

## 2. Setup config client

Dependencies:
```
 <dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-config</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

Properties:
```
spring.application.name=spring-cloud-config-client
spring.config.import=optional:configserver:http://localhost:8888/
management.endpoints.web.exposure.include=*
```

## 3. Extra stuff

* Specific repo configs
```
 repos:
    team-a:
        pattern: team-a-*
        cloneOnStart: true
        uri: https://git/team-a/config-repo.git
```
* Can also use REAID, JDBC
* Fail for config client
``spring.cloud.config.fail-fast=true``
* For Config client you can also add retry and aop for additional retry