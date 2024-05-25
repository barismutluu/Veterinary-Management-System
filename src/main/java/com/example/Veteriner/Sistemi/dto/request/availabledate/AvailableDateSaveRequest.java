package com.example.Veteriner.Sistemi.dto.request.availabledate;

// Lombok kütüphanesi kullanılarak oluşturulan getter, setter, equals, hashCode ve toString yöntemlerini otomatik olarak eklemek için gerekli annotasyonlar.

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Java'nın yerel tarih ve saat sınıfı olan LocalDate'i kullanmak için gerekli import
import java.time.LocalDate;

// Kullanılabilir tarih kaydetme isteğini temsil eden veri transfer nesnesi
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvailableDateSaveRequest {
    // Kullanılabilir tarihi temsil eden alan. LocalDate türü, yerel tarih ve saati saklamak için kullanılır.
    private LocalDate availableDate;

    // Bu kullanılabilir tarihi sağlayan veteriner doktorunun kimliğini temsil eden alan
    private long doctorId;
}
