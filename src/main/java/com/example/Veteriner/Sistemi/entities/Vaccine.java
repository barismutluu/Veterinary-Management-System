package com.example.Veteriner.Sistemi.entities;

// Gerekli JPA ve doğrulama kütüphaneleri import ediliyor.

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

// Bu sınıfın bir JPA Entity sınıfı olduğunu belirtiyoruz.
@Entity
// Veritabanındaki "vaccine" isimli tablo ile ilişkilendiriyoruz.
@Table(name = "vaccine")
// Lombok kütüphanesi ile getter, setter, toString, equals ve hashcode metodları otomatik olarak oluşturuluyor.
@Data
// Tüm argümanlara sahip bir constructor oluşturulmasını sağlıyoruz.
@AllArgsConstructor
// Parametresiz bir constructor oluşturulmasını sağlıyoruz.
@NoArgsConstructor
public class Vaccine {

    // Bu alanın tablodaki birincil anahtar olduğunu belirtiyoruz.
    @Id
    // Birincil anahtarın otomatik olarak arttırılmasını sağlıyoruz.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Veritabanındaki sütun adı ve türünü belirtiyoruz.
    @Column(name = "vaccine_id", columnDefinition = "serial")
    private long id;

    // Veritabanındaki sütun adı ve türünü belirtiyoruz.
    @Column(name = "vaccine_name")
    private String name;

    // Veritabanındaki sütun adı ve türünü belirtiyoruz.
    @Column(name = "vaccine_code")
    private String code;

    // Veritabanındaki sütun adı ve türünü belirtiyoruz.
    @Column(name = "vaccine_protectionStartDate")
    private LocalDate protectionStartDate;

    // Veritabanındaki sütun adı ve türünü belirtiyoruz.
    @Column(name = "vaccine_protectionFinishDate")
    private LocalDate protectionFinishDate;


    @ManyToOne(fetch = FetchType.LAZY)
    // Bu ilişkiyi "animal_id" sütunu üzerinden gerçekleştiriyoruz.
    @JoinColumn(name = "animal_id", referencedColumnName = "animal_id")
    private Animal animal;

}
