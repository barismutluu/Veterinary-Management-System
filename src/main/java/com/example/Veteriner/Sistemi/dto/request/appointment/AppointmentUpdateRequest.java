package com.example.Veteriner.Sistemi.dto.request.appointment;

// Gerekli validasyonları sağlamak için kullanılan annotasyonlar

import jakarta.validation.constraints.Positive;

// Lombok kütüphanesi kullanılarak otomatik olarak getter, setter, equals, hashCode ve toString yöntemlerini oluşturmak için gerekli annotasyonlar
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Java'nın yerel zaman (LocalDateTime) sınıfını kullanmak için gerekli import
import java.time.LocalDateTime;

// Randevu güncelleme isteğini temsil eden veri transfer nesnesi (DTO)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentUpdateRequest {
    // Randevu kimliğini temsil eden alan, pozitif olmalıdır
    @Positive
    private long id;

    // Randevu tarihini ve saati temsil eden alan
    private LocalDateTime appointmentDateTime;

    // Hayvan kimliğini temsil eden alan
    private int animalId;

    // Veteriner doktor kimliğini temsil eden alan
    private int doctorId;
}
