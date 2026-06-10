package com.java.basic_operations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//todo packages should be in lowercase w/o special characters
// basic_operations = > basicoperations
// create openDoc configuration bean and group api by version
// example for v1
//    @Bean
//    public GroupedOpenApi v1Api() {
//        return GroupedOpenApi.builder()
//                .group("v1")
//                .pathsToMatch("/api/v1/**")
//                .build();
//    }
//swagger doc: http://localhost:8080/swagger-ui/index.html
@SpringBootApplication
public class BasicOperationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasicOperationsApplication.class, args);
	}

}
