package com.example.product.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
	info = @Info(
		title="Product Service REST API Documentation",
		description = "Product Service REST API",
		version = "v1",
		contact = @Contact(
			name = "Sweta Goswami",
			email = "swetagoswami103@gmail.com"
		)
	),
	externalDocs = @ExternalDocumentation(
		description = "SharePoint URL Product service API",
		url = "Example.com"
	)
)
@SpringBootApplication
public class ProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}

}
