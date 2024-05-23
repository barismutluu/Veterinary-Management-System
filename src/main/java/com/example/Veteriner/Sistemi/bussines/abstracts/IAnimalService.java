package com.example.Veteriner.Sistemi.bussines.abstracts;

import com.example.Veteriner.Sistemi.entities.Animal;
import org.springframework.data.domain.Page;
import java.util.List;

public interface IAnimalService {
    Animal save(Animal animal);

    Animal get(long id);

    List<Animal> findByName(String name);

    Page<Animal> cursor(int page, int pageSize);

    Animal update(Animal animal);

    boolean delete(long id);
}
