package com.example.Veteriner.Sistemi.bussines.concretes;

import com.example.Veteriner.Sistemi.bussines.abstracts.ICustomerService;
import com.example.Veteriner.Sistemi.core.exception.NotFoundException;
import com.example.Veteriner.Sistemi.core.utilies.Msg;
import com.example.Veteriner.Sistemi.dao.AnimalRepo;
import com.example.Veteriner.Sistemi.dao.CustomerRepo;
import com.example.Veteriner.Sistemi.entities.Animal;
import com.example.Veteriner.Sistemi.entities.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

// Bu sınıf, ICustomerService arayüzünü uygular ve müşteri işlemlerini gerçekleştirir.
@Service
public class CustomerManager implements ICustomerService {
    private final CustomerRepo customerRepo;

    // CustomerManager sınıfının yapıcı metodudur.
    public CustomerManager(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    // Yeni bir müşteriyi kaydeder.
    @Override
    public Customer save(Customer customer) {
        return this.customerRepo.save(customer);
    }

    // Belirli bir müşteriyi ID'ye göre alır.
    @Override
    public Customer get(long id) {
        return this.customerRepo.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
    }

    // İsme göre müşterileri bulur.
    @Override
    public List<Customer> findByName(String name) {
        List<Customer> customers = this.customerRepo.findByName(name);
        if (customers.isEmpty()) {
            throw new NotFoundException(Msg.NOT_FOUND);
        }
        return customers;
    }

    // Sayfalama yaparak tüm müşterileri getirir.
    @Override
    public Page<Customer> cursor(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return this.customerRepo.findAll(pageable);
    }

    // Müşteri bilgilerini günceller.
    @Override
    public Customer update(Customer customer) {
        this.get(customer.getId());
        return this.customerRepo.save(customer);
    }

    // Belirli bir müşteriyi siler.
    @Override
    public boolean delete(long id) {
        Customer customer = this.get(id);
        this.customerRepo.delete(customer);
        return true;
    }
}
