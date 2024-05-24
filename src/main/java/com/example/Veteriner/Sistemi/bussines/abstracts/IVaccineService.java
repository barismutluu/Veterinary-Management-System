package com.example.Veteriner.Sistemi.bussines.abstracts;

import com.example.Veteriner.Sistemi.entities.Doctor;
import com.example.Veteriner.Sistemi.entities.Vaccine;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.List;

// IVaccineService arayüzü, aşı yönetimi için gerekli hizmet yöntemlerini tanımlar.
public interface IVaccineService {

    // Yeni bir aşı kaydeder ve kaydedilen aşıyı döner.
    Vaccine save(Vaccine vaccine);

    // Belirtilen kimliğe sahip bir aşıyı döner.
    Vaccine get(long id);

    // Sayfalama yaparak belirli bir sayfa numarası ve sayfa boyutuna göre aşıları döner.
    Page<Vaccine> cursor(int page, int pageSize);

    // Var olan bir aşıyı günceller ve güncellenmiş aşıyı döner.
    Vaccine update(Vaccine vaccine);

    // Belirtilen kimliğe sahip bir aşıyı siler ve başarılı olup olmadığını döner.
    boolean delete(long id);

    // Belirtilen hayvan kimliğine sahip tüm aşıları döner.
    List<Vaccine> getAllVaccinesByAnimalId(long animalId);

    // Belirtilen tarih aralığında gelecek aşıları döner.
    List<Vaccine> getUpcomingVaccines(LocalDate startDate, LocalDate endDate);
}
