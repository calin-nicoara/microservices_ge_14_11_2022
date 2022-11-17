# Spring Sleuth

Docs: https://docs.spring.io/spring-cloud-sleuth/docs/3.0.3/reference/htmlsingle/

## Docker zipkin
docker run -d -p 9411:9411 openzipkin/zipkin

## Dependencies

```
<dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-sleuth</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-sleuth-zipkin</artifactId>
    </dependency>
```
