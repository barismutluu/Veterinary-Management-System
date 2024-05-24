package com.example.Veteriner.Sistemi.core.config.modelMapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Bu sınıf, ModelMapper'ı yapılandırır ve istek ve cevap dönüşümleri için farklı eşleme stratejileri sağlar.
@Service
public class ModelManagerService implements IModelMapperService {
    private final ModelMapper modelMapper;

    // ModelManagerService'in yapıcı yöntemi, ModelMapper bağımlılığını enjekte eder.
    @Autowired
    public ModelManagerService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    // İstek için bir ModelMapper döndürür ve eşleme stratejisini STRICT olarak ayarlar.
    @Override
    public ModelMapper forRequest() {
        this.modelMapper.getConfiguration().setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.STRICT);
        return this.modelMapper;
    }

    // Yanıt için bir ModelMapper döndürür ve eşleme stratejisini STANDARD olarak ayarlar.
    @Override
    public ModelMapper forResponse() {
        this.modelMapper.getConfiguration().setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.STANDARD);
        return modelMapper;
    }
}
