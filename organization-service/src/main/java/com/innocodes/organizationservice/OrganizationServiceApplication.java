package com.innocodes.organizationservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Organization Service REST APIs",
				description = "Organization Service REST API Documentation",
				version = "v1.0",
				contact = @Contact(
						name = "Innocent",
						email = "omenka2innocent@gmail.com",
						url = "https://www.innocodes.com"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://www.innocodes.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Organization Service docs",
				url = "https://www.innocodes.com"
		)
)
public class OrganizationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrganizationServiceApplication.class, args);
	}

}
