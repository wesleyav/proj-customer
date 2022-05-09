package com.github.wesleyav.customercrudservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@SpringBootApplication
public class CustomerCrudServiceApplication {
	
	private static Logger logger = LoggerFactory.getLogger(CustomerCrudServiceApplication.class);

	public static void main(String[] args) {
		logger.info("Iniciando aplicação");
		SpringApplication.run(CustomerCrudServiceApplication.class, args);
		logger.info("Aplicação iniciada com sucesso!");
	}
	
	@Bean
    public OpenAPI customOpenAPI(@Value("${springdoc.version}") String appVersion) {
        return new OpenAPI()
        		.info(new Info()
        				.title("Demo project for Spring Boot - Customer")
        				.version(appVersion)
        				.description("This is a sample server created using springdocs - a library for OpenAPI 3 with spring boot.")
        				.termsOfService("http://swagger.io/terms/")
        				.license(new License().name("Apache 2.0")
        						.url("http://springdoc.org")));
    }

}
