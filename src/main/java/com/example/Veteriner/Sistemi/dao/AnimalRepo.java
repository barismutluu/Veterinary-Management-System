package com.example.Veteriner.Sistemi.dao;

import com.example.Veteriner.Sistemi.entities.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AnimalRepo extends JpaRepository<Animal,Long> {
    List<Animal> findByName(String name);
}
