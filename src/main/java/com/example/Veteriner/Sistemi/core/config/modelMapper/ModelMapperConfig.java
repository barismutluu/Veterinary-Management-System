package com.example.Veteriner.Sistemi.core.config.modelMapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Bu sınıf, ModelMapper'ın yapılandırılması için Spring konfigürasyonunu sağlar.
@Configuration
public class ModelMapperConfig {

    // ModelMapper nesnesini oluşturarak Spring konteynerine eklemek için bir bean metodu.
    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }
}
