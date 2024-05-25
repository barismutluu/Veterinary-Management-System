package com.example.Veteriner.Sistemi.dto.request.availabledate;

// Jakartanın sağladığı @Positive annotasyonu, id alanının pozitif olmasını sağlar.

import jakarta.validation.constraints.Positive;

// Lombok kütüphanesinden gelen annotasyonlar, getter, setter, equals, hashCode ve toString yöntemlerini otomatik olarak oluşturur.
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Java'nın LocalDate sınıfı, tarih ve saat bilgisi içeren bir nesne oluşturmak için kullanılır.
import java.time.LocalDate;

// Veri transfer nesnesi olarak işlev gören AvailableDateUpdateRequest sınıfı
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvailableDateUpdateRequest {
    // Kullanılabilir tarihin benzersiz kimliğini temsil eden alan
    @Positive
    private long id;

    // Kullanılabilir tarihi depolayan alan
    private LocalDate availableDate;

    // Bu kullanılabilir tarihi sağlayan veteriner doktorunun kimliğini temsil eden alan
    private long doctorId;
}
