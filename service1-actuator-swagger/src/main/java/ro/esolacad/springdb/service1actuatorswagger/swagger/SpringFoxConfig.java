package ro.esolacad.springdb.service1actuatorswagger.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SpringFoxConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

//    @Bean
//    public Docket customConfig() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("ro.esolacad.springdb.service1actuatorswagger.controller"))
//                .paths(PathSelectors.any())
//                .build()
//                .apiInfo(getApiInformation());
//    }
//
//    private ApiInfo getApiInformation(){
//        return new ApiInfo("Actuator and Swagger Example REST",
//                "Description of test applicaiton",
//                "1.0",
//                "termsofservice.com",
//                new Contact("Me", "www.me.com", "me@gmail.com"),
//                "LICENSE",
//                "LICENCE URL",
//                Collections.emptyList()
//        );
//    }
}
