package com.example.Veteriner.Sistemi.dto.request.animal;

// Lombok kütüphanesi kullanılarak oluşturulan getter, setter, equals, hashCode ve toString yöntemlerini otomatik olarak eklemek için gerekli annotasyonlar.

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Java 8'den gelen LocalDate sınıfını kullanarak tarih bilgisi saklayan bir alan eklemek için gerekli import ifadesi.
import java.time.LocalDate;

// Veri transfer nesnesi olarak işlev gören AnimalSaveRequest sınıfı
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalSaveRequest {

    // Hayvanın adını temsil eden alan
    private String name;

    // Hayvanın türünü temsil eden alan
    private String species;

    // Hayvanın cinsini temsil eden alan
    private String breed;

    // Hayvanın cinsiyetini temsil eden alan
    private String gender;

    // Hayvanın rengini temsil eden alan
    private String colour;

    // Hayvanın doğum tarihini temsil eden alan
    private LocalDate dateOfBirth;

    // Bu hayvanı sahiplenen müşterinin kimliğini temsil eden alan
    private long customerId;
}
