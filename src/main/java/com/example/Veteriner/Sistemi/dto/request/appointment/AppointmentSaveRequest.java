package com.example.Veteriner.Sistemi.dto.request.appointment;

// Lombok kütüphanesi kullanılarak oluşturulan getter, setter, equals, hashCode ve toString yöntemlerini otomatik olarak eklemek için gerekli annotasyonlar.
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

// Randevu kaydetme isteğini temsil eden veri transfer nesnesi
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentSaveRequest {

    // Randevunun tarih ve saatini temsil eden alan
    private LocalDateTime appointmentDateTime;

    // Randevu için atanmış olan hayvanın kimliğini temsil eden alan
    private int animalId;

    // Randevuyu verecek olan veteriner doktorunun kimliğini temsil eden alan
    private int doctorId;
}
