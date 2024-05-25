package com.example.Veteriner.Sistemi.dto.request.customer;

// Jakartan Validation API'sinden gelen annotasyonları kullanarak alan doğrulaması sağlar.

import jakarta.validation.constraints.Positive;

// Lombok kütüphanesi kullanılarak oluşturulan getter, setter, equals, hashCode ve toString yöntemlerini otomatik olarak eklemek için gerekli annotasyonlar.
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Müşteri güncelleme isteğini temsil eden CustomerUpdateRequest sınıfı
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerUpdateRequest {
    // Müşterinin benzersiz kimliğini temsil eden alan
    @Positive
    private long id;

    // Müşterinin adını temsil eden alan
    private String name;

    // Müşterinin telefon numarasını temsil eden alan
    private String phone;

    // Müşterinin e-posta adresini temsil eden alan
    private String mail;

    // Müşterinin adresini temsil eden alan
    private String address;

    // Müşterinin şehrini temsil eden alan
    private String city;
}
