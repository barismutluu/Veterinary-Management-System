package com.example.Veteriner.Sistemi.bussines.abstracts;

import com.example.Veteriner.Sistemi.entities.Animal;
import com.example.Veteriner.Sistemi.entities.Customer;
import org.springframework.data.domain.Page;

import java.util.List;

// ICustomerService arayüzü, müşteri yönetimi için gerekli hizmet yöntemlerini tanımlar.
public interface ICustomerService {

    // Yeni bir müşteri kaydeder ve kaydedilen müşteriyi döner.
    Customer save(Customer customer);

    // Belirtilen kimliğe sahip bir müşteriyi döner.
    Customer get(long id);

    // Belirtilen ada göre müşteri listesi döner.
    List<Customer> findByName(String name);

    // Sayfalama yaparak belirli bir sayfa numarası ve sayfa boyutuna göre müşterileri döner.
    Page<Customer> cursor(int page, int pageSize);

    // Var olan bir müşteriyi günceller ve güncellenmiş müşteriyi döner.
    Customer update(Customer customer);

    // Belirtilen kimliğe sahip bir müşteriyi siler ve başarılı olup olmadığını döner.
    boolean delete(long id);
}
