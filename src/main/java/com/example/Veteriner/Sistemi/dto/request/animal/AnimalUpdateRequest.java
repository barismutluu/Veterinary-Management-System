package com.example.Veteriner.Sistemi.dto.request.animal;

// Veri transfer nesnesi olarak işlev gören AnimalUpdateRequest sınıfı

import jakarta.validation.constraints.Positive; // Bu kütüphane, id alanının pozitif olmasını zorlar
import lombok.AllArgsConstructor; // Lombok'ten gelen constructor oluşturma işlevini eklemek için gerekli annotasyon
import lombok.Data; // Lombok'ten gelen getter, setter, equals, hashCode ve toString yöntemlerini otomatik olarak eklemek için gerekli annotasyon
import lombok.NoArgsConstructor; // Lombok'ten gelen boş constructor oluşturma işlevini eklemek için gerekli annotasyon

import java.time.LocalDate; // LocalDate sınıfını kullanarak doğum tarihini temsil etmek için gerekli kütüphane

@Data
@AllArgsConstructor // Tüm alanları içeren bir constructor oluşturur
@NoArgsConstructor // Boş bir constructor oluşturur
public class AnimalUpdateRequest {
    @Positive // id alanının pozitif olması gerektiğini belirtir
    private long id; // Hayvanın benzersiz kimliğini temsil eden alan

    private String name; // Hayvanın adını temsil eden alan

    private String species; // Hayvanın türünü temsil eden alan

    private String breed; // Hayvanın cinsini temsil eden alan

    private String gender; // Hayvanın cinsiyetini temsil eden alan

    private String colour; // Hayvanın rengini temsil eden alan

    private LocalDate dateOfBirth; // Hayvanın doğum tarihini temsil eden alan

    private long customerId; // Hayvanın sahibinin kimliğini temsil eden alan
}
