package com.example.Veteriner.Sistemi.core.config.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;

@Configuration
public class SwaggerConfiguration {

        @Bean
        public OpenAPI openAPI() {
            return new OpenAPI().info(new Info()
                    .title("Veteriner Sistemi")
                    .description("Veteriner project for Spring Boot")
                    .contact(new Contact().name("Baris"))
                    .version("1.0.0"));
        }

    }
