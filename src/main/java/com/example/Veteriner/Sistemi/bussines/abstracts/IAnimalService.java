package com.example.Veteriner.Sistemi.bussines.abstracts;

import com.example.Veteriner.Sistemi.entities.Animal;
import org.springframework.data.domain.Page;

import java.util.List;

// Bu arayüz, hayvanlarla ilgili iş mantığı operasyonlarını tanımlar.
public interface IAnimalService {

    // Bir hayvan kaydı ekler ve eklenen hayvanı geri döner.
    Animal save(Animal animal);

    // Verilen kimlik numarasına sahip hayvanı getirir.
    Animal get(long id);

    // Verilen ada sahip hayvanların listesini döner.
    List<Animal> findByName(String name);

    // Belirtilen sayfa numarası ve sayfa boyutuna göre hayvan kayıtlarını döner.
    Page<Animal> cursor(int page, int pageSize);

    // Bir hayvan kaydını günceller ve güncellenen hayvanı geri döner.
    Animal update(Animal animal);

    // Verilen kimlik numarasına sahip hayvan kaydını siler ve silme işleminin başarılı olup olmadığını döner.
    boolean delete(long id);

    // Belirli bir müşteriye ait tüm hayvanları getirir.
    List<Animal> getCustomerAnimals(long customerId);
}
