package com.example.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

//    @Bean
    public RouteLocator customRouteLocation(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("store-service", r ->
                        r.path("/store/**")
                                .filters(f -> f.stripPrefix(1))
                                .uri("http://localhost:8083")
                )
                .build();
    }
}
