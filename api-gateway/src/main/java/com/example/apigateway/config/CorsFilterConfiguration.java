package com.example.apigateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsConfigurationSource;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

@EnableWebFluxSecurity
public class CorsFilterConfiguration {

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();

        config.addAllowedOrigin("http://localhost:4200");
//        config.addAllowedOrigin("*");
        config.setAllowCredentials(true);
        config.addAllowedHeader(CorsConfiguration.ALL);
        config.addExposedHeader(HttpHeaders.CONTENT_DISPOSITION);
        config.addAllowedMethod(CorsConfiguration.ALL);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return source;
    }
}
