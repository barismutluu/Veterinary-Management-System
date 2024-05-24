package com.example.Veteriner.Sistemi.core.config.modelMapper;

import org.modelmapper.ModelMapper;

// Bu arayüz, ModelMapper nesnelerini oluşturmak için bir servis sağlar.
public interface IModelMapperService {
    // Gelen istek nesnelerini dönüştürmek için bir ModelMapper nesnesi döndürür.
    ModelMapper forRequest();

    // Yanıt nesnelerini dönüştürmek için bir ModelMapper nesnesi döndürür.
    ModelMapper forResponse();
}
