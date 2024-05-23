package com.example.Veteriner.Sistemi.bussines.concretes;

import com.example.Veteriner.Sistemi.bussines.abstracts.IAnimalService;
import com.example.Veteriner.Sistemi.bussines.abstracts.IVaccineService;
import com.example.Veteriner.Sistemi.core.exception.NotFoundException;
import com.example.Veteriner.Sistemi.core.utilies.Msg;
import com.example.Veteriner.Sistemi.dao.AnimalRepo;
import com.example.Veteriner.Sistemi.dao.VaccineRepo;
import com.example.Veteriner.Sistemi.entities.Animal;
import com.example.Veteriner.Sistemi.entities.Vaccine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VaccineManager implements IVaccineService {
    private final VaccineRepo vaccineRepo;

    public VaccineManager(VaccineRepo vaccineRepo) {
        this.vaccineRepo = vaccineRepo;
    }

    @Override
    public Vaccine save(Vaccine vaccine) {
        return this.vaccineRepo.save(vaccine);
    }

    @Override
    public Vaccine get(long id) {
        return this.vaccineRepo.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
    }

    @Override
    public List<Vaccine> getAllVaccinesByAnimalId(long animalId) {
        return this.vaccineRepo.findAllByAnimalId(animalId);
    }

    @Override
    public Page<Vaccine> cursor(int page, int pageSize) {
        Pageable pageable= PageRequest.of(page, pageSize);
        return this.vaccineRepo.findAll(pageable);
    }


    @Override
    public Vaccine update(Vaccine vaccine) {
        this.get(vaccine.getId());
        return this.vaccineRepo.save(vaccine);
    }

    @Override
    public boolean delete(long id) {
        Vaccine vaccine=this.get(id);
        this.vaccineRepo.delete(vaccine);
        return true;
    }
    @Override
    public List<Vaccine> getUpcomingVaccines(LocalDate startDate, LocalDate endDate) {
        return this.vaccineRepo.findByProtectionFinishDateBetween(startDate, endDate);
    }
}
