# Swagger

UI Tool for showing HTTP endpoints and interacting with those endpoints

## 1. Setup

* Add dependencies:
```
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-boot-starter</artifactId>
    <version>3.0.0</version>
</dependency>
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger-ui</artifactId>
    <version>3.0.0</version>
</dependency>
```
* Add config class with basic configuration
```
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
}
```

## 2. Custom configuration
```
 @Bean
public Docket customConfig() {
    return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("ro.esolacad.springdb.service1actuatorswagger.controller"))
            .paths(PathSelectors.any())
            .build()
            .apiInfo(getApiInformation());
}

private ApiInfo getApiInformation(){
    return new ApiInfo("Actuator and Swagger Example REST",
            "Description of test applicaiton",
            "1.0",
            "termsofservice.com",
            new Contact("Me", "www.me.com", "me@gmail.com"),
            "LICENSE",
            "LICENCE URL",
            Collections.emptyList()
    );
}
```

## 3. Access endpoints

* API DOC endpoint: "<host>/<root>/v2/api-docs"
* SWAGGER UI endpoint: "<host>/<root>/swagger-ui/index.html"


## 4. Security config

```
@Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests()
                .antMatchers("/swagger-ui/*", "/swagger-ui.html", "/webjars/**", "/v2/**", "/swagger-resources/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .cors()
                .and()
                .csrf()
                .disable()
                .oauth2ResourceServer()
                .jwt();
    }
```

### Spring Fox config
```
@Configuration
public class SpringFoxConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
                .securityContexts(Arrays.asList(securityContext()))
                .securitySchemes(Arrays.asList(apiKey()))
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private ApiKey apiKey() {
        return new ApiKey("JWT", "Authorization", "header");
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder().securityReferences(defaultAuth()).build();
    }

    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Arrays.asList(new SecurityReference("JWT", authorizationScopes));
    }


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
```
