package ro.esolacad.msge.storeservice.product.feign;

import org.springframework.context.annotation.Configuration;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.oauth2.jwt.Jwt;

@Configuration
public class SimpleFeingInterceptorConfiguration {

//    @Bean
//    public RequestInterceptor requestInterceptor() {
//        return requestTemplate -> {
//            Jwt jwt = (Jwt) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//            requestTemplate.header("Authorization", "Bearer " + jwt.getTokenValue());
//        };
//    }
}
