```
server.port: 8999
spring:
  cloud:
    discovery:
      enabled: true
    gateway:
      globalcors:
        cors-configurations:
          '[/**]':
            allowedOrigins: http://localhost:4200
      discovery:
        locator:
          enabled: true
          lower-case-service-id: true
      routes:
        - id: store-service
          uri: lb://store-service
          predicates:
            - Path=/store/**
#            - After
#          - Before=2017-09-11T17:42:47.789-07:00[America/Alaska]
#            - Host=http://localhost
          filters:
            - StripPrefix=1
            - AddResponseHeader=X-CUSTOM-RESPONSE,HELLO
        - id: checkout-service
          uri: lb://checkout-service
          predicates:
            - Path=/checkout/**
          filters:
            - StripPrefix=1
  application:
    name: gateway-service

```
