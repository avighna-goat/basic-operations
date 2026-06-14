package com.java.basicoperations.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//swagger doc: http://localhost:8080/swagger-ui/index.html
@Configuration
public class OpenApiGroupConfig {

    @Bean
    public GroupedOpenApi v1Api() {
        return GroupedOpenApi.builder()
                .group("v1")
                .pathsToMatch("/api/v1/**")
                .build();
    }

    @Bean
    public GroupedOpenApi v2Api() {
        return GroupedOpenApi.builder()
                .group("v2")
                .pathsToMatch("/api/v2/**")
                .build();
    }

    //h2 database api
    @Bean
    public GroupedOpenApi h2Api() {
        return GroupedOpenApi.builder()
                .group("h2")
                .pathsToMatch("/h2/**")
                .build();
    }
}
