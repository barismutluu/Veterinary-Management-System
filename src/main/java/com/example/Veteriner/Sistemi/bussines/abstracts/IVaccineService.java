package com.example.Veteriner.Sistemi.bussines.abstracts;

import com.example.Veteriner.Sistemi.entities.Doctor;
import com.example.Veteriner.Sistemi.entities.Vaccine;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.List;

public interface IVaccineService {
    Vaccine save(Vaccine vaccine);

    Vaccine get(long id);

    Page<Vaccine> cursor(int page, int pageSize);

    Vaccine update(Vaccine vaccine);

    boolean delete(long id);

    List<Vaccine> getAllVaccinesByAnimalId(long animalId);

    List<Vaccine> getUpcomingVaccines(LocalDate startDate, LocalDate endDate);
}
