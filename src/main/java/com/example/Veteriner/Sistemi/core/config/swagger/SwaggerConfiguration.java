package com.example.Veteriner.Sistemi.core.config.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Swagger yapılandırması için kullanılan sınıfı tanımlar.
@Configuration
public class SwaggerConfiguration {

    // OpenAPI nesnesini oluşturan bir Bean metodu.
    @Bean
    public OpenAPI openAPI() {
        // Yeni bir OpenAPI nesnesi oluşturur ve bilgi kısmını ayarlar.
        return new OpenAPI().info(new Info()
                // API'nin başlığını belirler.
                .title("Veteriner Sistemi")
                // API'nin açıklamasını belirler.
                .description("Spring Boot için Veteriner projesi")
                // API ile ilgili kişiyi belirler.
                .contact(new Contact().name("Baris"))
                // API sürümünü belirler.
                .version("1.0.0"));
    }
}
