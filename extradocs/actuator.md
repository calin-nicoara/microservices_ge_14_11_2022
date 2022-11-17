# Actuator for Spring Boot

Docs: https://docs.spring.io/spring-boot/docs/2.5.4/reference/htmlsingle/#production-ready

## 1. Use dependency

```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

## 2. Endpoints


* /actuator/health - shows if application is running ok
* /actuator/env - properties of spring application (port, systemProperties, applicationProperties)

Enable endpoints:
```
management.endpoint.shutdown.enabled=true
management.endpoints.web.exposure.include=*
```

### 3. Change port

```
server.port: 9000
management.server.port: 9001
management.server.address: 127.0.0.1
```

### 4. Custom actuator endpoints

* Automatically sent to JMX and HTTP if web application
* Http path is set by id of @Endpoint
* Only one method per operation (GET, POST, etc) in a configuration class 
```
@Configuration
@Endpoint(id="greeting")
public class ActuatorConfig {

    @ReadOperation
    @Bean
    public Greeting getGreeting() {
        return new Greeting(2, "HELLO THERE");
    }
}
```

### Health information

* Add property to see extra information on HEALTH CHECK
* Health indicators are added according to Spring Boot dependencies
* Custom Health indicators can also be written
```
management.endpoint.health.show-details=always
```

* KUBERNETES
  * Health probes are automatically added in a KUBERNETES environmnet
  * Manually enable them: ``management.endpoint.health.probes.enabled``