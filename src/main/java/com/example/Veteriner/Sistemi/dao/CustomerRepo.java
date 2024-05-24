package com.example.Veteriner.Sistemi.dao;

import com.example.Veteriner.Sistemi.entities.Animal;
import com.example.Veteriner.Sistemi.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// Bu interface, Spring Data JPA'nın JpaRepository arayüzünü genişletir.
// Bu, Customer varlığını yönetmek için standart CRUD (Create, Read, Update, Delete) işlemlerini gerçekleştirmek için gereken metotları sağlar.
@Repository
public interface CustomerRepo extends JpaRepository<Customer,Long> {

    // Belirli bir isme sahip müşterileri bulmak için özel bir sorgu sağlar.
    // Bu metodun implementasyonu Spring Data JPA tarafından otomatik olarak oluşturulur.
    // 'name' parametresi, müşterileri isimlerine göre aramak için kullanılır.
    List<Customer> findByName(String name);
}
