package com.example.Veteriner.Sistemi.dao;

// Gerekli importlar
import com.example.Veteriner.Sistemi.entities.Doctor;
import com.example.Veteriner.Sistemi.entities.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
// VaccineRepo interface'i, JpaRepository'den genişler ve Vaccine entity'si için CRUD işlemlerini sağlar.
public interface VaccineRepo extends JpaRepository<Vaccine,Long> {
    // Belirli bir hayvanın tüm aşılarını bulmak için kullanılır.
    List<Vaccine> findAllByAnimalId(long animalId);

    // Belirli bir koruma bitiş tarihi aralığında aşıları bulmak için kullanılır.
    List<Vaccine> findByProtectionFinishDateBetween(LocalDate startDate, LocalDate endDate);
}
