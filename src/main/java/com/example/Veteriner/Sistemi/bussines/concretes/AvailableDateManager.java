package com.example.Veteriner.Sistemi.bussines.concretes;

import com.example.Veteriner.Sistemi.bussines.abstracts.IAnimalService;
import com.example.Veteriner.Sistemi.bussines.abstracts.IAvailableDateService;
import com.example.Veteriner.Sistemi.core.exception.NotFoundException;
import com.example.Veteriner.Sistemi.core.utilies.Msg;
import com.example.Veteriner.Sistemi.dao.AnimalRepo;
import com.example.Veteriner.Sistemi.dao.AvailableDateRepo;
import com.example.Veteriner.Sistemi.entities.Animal;
import com.example.Veteriner.Sistemi.entities.AvailableDate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

// Bu sınıf, IAvailableDateService arayüzünü uygular ve kullanılabilir tarih yönetim işlemlerini gerçekleştirir.
@Service
public class AvailableDateManager implements IAvailableDateService {
    private final AvailableDateRepo availableDateRepo;

    // AvailableDateRepo bağımlılığı enjekte edilir.
    public AvailableDateManager(AvailableDateRepo availableDateRepo) {
        this.availableDateRepo = availableDateRepo;
    }

    // Yeni bir AvailableDate kaydını veritabanına kaydeder.
    @Override
    public AvailableDate save(AvailableDate availableDate) {
        return this.availableDateRepo.save(availableDate);
    }

    // Belirli bir AvailableDate kaydını veritabanından bulur.
    // Eğer bulunamazsa NotFoundException fırlatılır.
    @Override
    public AvailableDate get(long id) {
        return this.availableDateRepo.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
    }

    // Sayfalama yapılarak tüm AvailableDate kayıtlarını getirir.
    @Override
    public Page<AvailableDate> cursor(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return this.availableDateRepo.findAll(pageable);
    }

    // Varolan bir AvailableDate kaydını günceller.
    // Eğer kayıt bulunamazsa NotFoundException fırlatılır.
    @Override
    public AvailableDate update(AvailableDate availableDate) {
        this.get(availableDate.getId()); // Güncellenecek kaydın varlığını kontrol etmek için get metodu çağrılır.
        return this.availableDateRepo.save(availableDate);
    }

    // Belirli bir AvailableDate kaydını siler.
    // Eğer kayıt bulunamazsa NotFoundException fırlatılır.
    @Override
    public boolean delete(long id) {
        AvailableDate availableDate = this.get(id); // Silinecek kaydı alır.
        this.availableDateRepo.delete(availableDate); // Kaydı siler.
        return true;
    }
}
