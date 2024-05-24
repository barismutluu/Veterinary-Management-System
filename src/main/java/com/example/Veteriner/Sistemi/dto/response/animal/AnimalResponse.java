package com.example.Veteriner.Sistemi.dto.response.animal;

// Lombok kütüphanesi tarafından otomatik olarak oluşturulan getter, setter, equals, hashCode ve toString gibi metodları sağlar.
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

// Veri transfer nesnesi (DTO) olarak kullanılmak üzere tasarlanmış sınıf.
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalResponse {
    // Hayvanın benzersiz kimliği.
    private long id;
    // Hayvanın adı.
    private String name;
    // Hayvanın türü.
    private String species;
    // Hayvanın cinsi.
    private String breed;
    // Hayvanın cinsiyeti.
    private String gender;
    // Hayvanın rengi.
    private String colour;
    // Hayvanın doğum tarihi.
    private LocalDate dateOfBirth;
    // Hayvanın sahibinin kimliği.
    private long customerId;
}
