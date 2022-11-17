package ro.esolacad.springdb.service1actuatorswagger.controller;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Endpoint(id="greeting")
public class ActuatorConfig {

    @ReadOperation
    @Bean
    public Greeting getGreeting() {
        return new Greeting(2, "HELLO THERE");
    }
}
