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

// Bu sınıf, IVaccineService arayüzünü uygular ve aşılarla ilgili iş mantığını yönetir.
@Service
public class VaccineManager implements IVaccineService {
    private final VaccineRepo vaccineRepo;

    // Bağımlılık enjeksiyonu yapmak için VaccineRepo nesnesini enjekte eder.
    public VaccineManager(VaccineRepo vaccineRepo) {
        this.vaccineRepo = vaccineRepo;
    }

    // Yeni bir aşı kaydını veritabanına ekler.
    @Override
    public Vaccine save(Vaccine vaccine) {
        return this.vaccineRepo.save(vaccine);
    }

    // Belirli bir aşıyı ID'ye göre getirir.
    @Override
    public Vaccine get(long id) {
        return this.vaccineRepo.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
    }

    // Bir hayvanın tüm aşılarını getirir.
    @Override
    public List<Vaccine> getAllVaccinesByAnimalId(long animalId) {
        return this.vaccineRepo.findAllByAnimalId(animalId);
    }

    // Sayfalı bir şekilde tüm aşıları getirir.
    @Override
    public Page<Vaccine> cursor(int page, int pageSize) {
        Pageable pageable= PageRequest.of(page, pageSize);
        return this.vaccineRepo.findAll(pageable);
    }

    // Var olan bir aşıyı günceller.
    @Override
    public Vaccine update(Vaccine vaccine) {
        this.get(vaccine.getId());
        return this.vaccineRepo.save(vaccine);
    }

    // Belirli bir aşıyı siler.
    @Override
    public boolean delete(long id) {
        Vaccine vaccine=this.get(id);
        this.vaccineRepo.delete(vaccine);
        return true;
    }

    // Belirli bir tarih aralığında gelecek aşıları getirir.
    @Override
    public List<Vaccine> getUpcomingVaccines(LocalDate startDate, LocalDate endDate) {
        return this.vaccineRepo.findByProtectionFinishDateBetween(startDate, endDate);
    }
}
