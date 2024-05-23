package com.example.Veteriner.Sistemi.dao;

import com.example.Veteriner.Sistemi.entities.Doctor;
import com.example.Veteriner.Sistemi.entities.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VaccineRepo extends JpaRepository<Vaccine,Long> {
    List<Vaccine> findAllByAnimalId(long animalId);
    List<Vaccine> findByProtectionFinishDateBetween(LocalDate startDate, LocalDate endDate);
}
