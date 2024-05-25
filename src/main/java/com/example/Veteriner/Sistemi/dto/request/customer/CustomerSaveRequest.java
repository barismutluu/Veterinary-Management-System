package com.example.Veteriner.Sistemi.dto.request.customer;

// Lombok kütüphanesi kullanılarak oluşturulan getter, setter, equals, hashCode ve toString yöntemlerini otomatik olarak eklemek için gerekli annotasyonlar.

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Müşteri bilgilerini kaydetmek için kullanılan veri transfer nesnesi
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerSaveRequest {
    // Müşterinin adını temsil eden alan
    private String name;

    // Müşterinin telefon numarasını temsil eden alan
    private String phone;

    // Müşterinin e-posta adresini temsil eden alan
    private String mail;

    // Müşterinin adresini temsil eden alan
    private String address;

    // Müşterinin yaşadığı şehri temsil eden alan
    private String city;
}
