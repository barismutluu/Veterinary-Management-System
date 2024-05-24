package com.example.Veteriner.Sistemi.dao;

// Spring Data JPA ile çalışmak için gerekli olan JpaRepository arayüzü
import org.springframework.data.jpa.repository.JpaRepository;
// Spring Bean'i olarak tanımlamak için gerekli annotasyon
import org.springframework.stereotype.Repository;
// Animal sınıfını kullanmak için gerekli import
import com.example.Veteriner.Sistemi.entities.Animal;
// Liste veri yapısını kullanabilmek için gerekli import
import java.util.List;

// Bu interface, veritabanına erişmek için kullanılacak olan AnimalRepo DAO'yu tanımlar.
@Repository
public interface AnimalRepo extends JpaRepository<Animal, Long> {
    // Veritabanında belirli bir isme sahip hayvanları bulmak için kullanılacak olan metot.
    List<Animal> findByName(String name);

    // Veritabanında belirli bir müşteriye ait hayvanları bulmak için kullanılacak olan metot.
    List<Animal> findByCustomerId(long customerId);

}
