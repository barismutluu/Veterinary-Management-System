package com.example.Veteriner.Sistemi.bussines.abstracts;

import com.example.Veteriner.Sistemi.entities.Animal;
import com.example.Veteriner.Sistemi.entities.Customer;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ICustomerService {
    Customer save(Customer customer);

    Customer get(long id);
    List<Customer> findByName(String name);

    Page<Customer> cursor(int page, int pageSize);

    Customer update(Customer customer);

    boolean delete(long id);
}
