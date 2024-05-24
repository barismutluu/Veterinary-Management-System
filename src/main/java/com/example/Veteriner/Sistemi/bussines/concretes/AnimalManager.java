package com.example.Veteriner.Sistemi.bussines.concretes;

import com.example.Veteriner.Sistemi.bussines.abstracts.IAnimalService;
import com.example.Veteriner.Sistemi.core.exception.NotFoundException;
import com.example.Veteriner.Sistemi.core.utilies.Msg;
import com.example.Veteriner.Sistemi.dao.AnimalRepo;
import com.example.Veteriner.Sistemi.entities.Animal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

// Bu sınıf, IAnimalService arayüzünü uygular ve hayvan işlemlerini gerçekleştirir.
@Service
public class AnimalManager implements IAnimalService {

    private final AnimalRepo animalRepo;

    // Hayvan yöneticisi sınıfının yapıcı metodu, AnimalRepo bağımlılığını enjekte eder.
    public AnimalManager(AnimalRepo animalRepo) {
        this.animalRepo = animalRepo;
    }

    // Yeni bir hayvanı kaydeder.
    @Override
    public Animal save(Animal animal) {
        return this.animalRepo.save(animal);
    }

    // Belirli bir ID'ye sahip hayvanı getirir, bulunamazsa istisna fırlatır.
    @Override
    public Animal get(long id) {
        return this.animalRepo.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
    }

    @Override
    public List<Animal> getCustomerAnimals(long customerId) {
        // Müşteriye ait hayvanları almak için animalRepo kullanılır.
        return this.animalRepo.findByCustomerId(customerId);
    }

    // Belirli bir isme sahip hayvanları bulur, bulunamazsa istisna fırlatır.
    @Override
    public List<Animal> findByName(String name) {
        List<Animal> animals = this.animalRepo.findByName(name);
        if (animals.isEmpty()) {
            throw new NotFoundException(Msg.NOT_FOUND);
        }
        return animals;
    }

    // Sayfalı bir şekilde tüm hayvanları getirir.
    @Override
    public Page<Animal> cursor(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return this.animalRepo.findAll(pageable);
    }

    // Var olan bir hayvanın bilgilerini günceller.
    @Override
    public Animal update(Animal animal) {
        this.get(animal.getId());
        return this.animalRepo.save(animal);
    }

    // Belirli bir ID'ye sahip hayvanı siler.
    @Override
    public boolean delete(long id) {
        Animal animal = this.get(id);
        this.animalRepo.delete(animal);
        return true;
    }

    // Belirli bir ID'ye sahip hayvanın veritabanında bulunup bulunmadığını kontrol eder.
    public boolean existsById(long id) {
        return animalRepo.existsById(id);
    }
}
