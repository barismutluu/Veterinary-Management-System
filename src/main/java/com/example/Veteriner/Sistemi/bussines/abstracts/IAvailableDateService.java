package com.example.Veteriner.Sistemi.bussines.abstracts;

import com.example.Veteriner.Sistemi.entities.Animal;
import com.example.Veteriner.Sistemi.entities.AvailableDate;
import org.springframework.data.domain.Page;

// IAvailableDateService arayüzü, mevcut tarihler yönetimi için gerekli hizmet yöntemlerini tanımlar.
public interface IAvailableDateService {

    // Yeni bir mevcut tarihi kaydeder ve kaydedilen mevcut tarihi döner.
    AvailableDate save(AvailableDate availableDate);

    // Belirtilen kimliğe sahip bir mevcut tarihi döner.
    AvailableDate get(long id);

    // Sayfalama yaparak belirli bir sayfa numarası ve sayfa boyutuna göre mevcut tarihleri döner.
    Page<AvailableDate> cursor(int page, int pageSize);

    // Var olan bir mevcut tarihi günceller ve güncellenmiş mevcut tarihi döner.
    AvailableDate update(AvailableDate availableDate);

    // Belirtilen kimliğe sahip bir mevcut tarihi siler ve başarılı olup olmadığını döner.
    boolean delete(long id);
}
