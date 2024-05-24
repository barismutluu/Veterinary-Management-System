package com.example.Veteriner.Sistemi.dto.response.appointment;

// Import ifadeleri eksik, gerekli olan diğer sınıfların import edilmesi gerekiyor.
// Örneğin: import java.time.LocalDateTime;

// Lombok kütüphanesinden gelen işaretçiler
import lombok.AllArgsConstructor; // Tüm alanlar için parametreli bir constructor oluşturur.
import lombok.Data; // Getter ve setter metodlarını otomatik olarak oluşturur, toString(), equals() ve hashCode() metodlarını ekler.
import lombok.NoArgsConstructor; // Parametresiz bir constructor ekler.

import java.time.LocalDate; // Tarih bilgisi için
import java.time.LocalDateTime; // Tarih ve saat bilgisi için

// Randevu bilgilerini içeren DTO (Data Transfer Object) sınıfı
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentResponse {

    // Randevu ID'si
    private long id;

    // Randevu tarihi ve saati
    private LocalDateTime appointmentDateTime;

    // Randevuya ait hayvanın ID'si
    private int animalId;

    // Randevuyu sağlayacak doktorun ID'si
    private int doctorId;
}
