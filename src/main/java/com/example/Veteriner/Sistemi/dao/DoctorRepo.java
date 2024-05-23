package com.example.Veteriner.Sistemi.dao;

import com.example.Veteriner.Sistemi.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor,Long> {
}
