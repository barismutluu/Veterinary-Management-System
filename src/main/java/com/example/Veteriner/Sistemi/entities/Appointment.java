package com.example.Veteriner.Sistemi.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity // Bu sınıfın bir JPA entity olduğunu belirtir.
@Table(name = "appointment") // Veritabanında kullanılacak tablo adını belirtir.
@Data // Lombok kütüphanesi tarafından sağlanan getter, setter ve toString gibi yöntemleri otomatik olarak ekler.
@AllArgsConstructor // Tüm alanları içeren bir constructor oluşturur.
@NoArgsConstructor // Boş bir constructor oluşturur.
public class Appointment {
    @Id // Bu alanın birincil anahtar (primary key) olduğunu belirtir.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Otomatik artan (auto-increment) bir değerle bu alanın doldurulacağını belirtir.
    @Column(name = "appointment_id", columnDefinition = "serial") // Veritabanı sütun adını ve özelliklerini belirtir.
    private long id; // Randevu ID'si.

    @NotNull // Bu alanın null olamayacağını belirtir.
    @Column(name = "appointmentDateTime") // Veritabanı sütun adını belirtir.
    private LocalDateTime appointmentDateTime; // Randevunun tarihi ve saati.

    @ManyToOne(fetch = FetchType.LAZY) // Birçok randevunun bir hayvana atanabileceğini belirtir.
    @JoinColumn(name = "animal_id", referencedColumnName = "animal_id")
    // İlişkilendirme için kullanılacak sütunları belirtir.
    private Animal animal; // Randevu sahibi hayvan.

    @ManyToOne(fetch = FetchType.LAZY) // Birçok randevunun bir doktora atanabileceğini belirtir.
    @JoinColumn(name = "doctor_id", referencedColumnName = "doctor_id")
    // İlişkilendirme için kullanılacak sütunları belirtir.
    private Doctor doctor; // Randevuyu alan doktor.
}
