package com.example.Veteriner.Sistemi.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "availabledate") // Veritabanında bu varlık için kullanılacak tablo adı
@Data
@AllArgsConstructor // Tüm alanları içeren bir constructor oluşturur
@NoArgsConstructor // Boş bir constructor oluşturur
public class AvailableDate {
    @Id // Bu alanın birincil anahtar alanı olduğunu belirtir
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Otomatik artan bir değerle doldurulacağını belirtir
    @Column(name = "availabledate_id", columnDefinition = "serial") // Veritabanındaki sütun adı ve özellikleri
    private long id;

    @NotNull // Bu alanın null olamayacağını belirtir
    @Column(name = "availabledate") // Veritabanındaki sütun adı
    private LocalDate availableDate; // Kullanılabilir tarih

    @ManyToOne(fetch = FetchType.LAZY) // Birçok AvailableDate nesnesine karşılık gelebileceğini belirtir
    @JoinColumn(name = "doctor_id", referencedColumnName = "doctor_id")
    // İlişkilendirilecek doktor nesnesinin sütun adı
    private Doctor doctor; // Bu tarihte hizmet verecek doktor
}
