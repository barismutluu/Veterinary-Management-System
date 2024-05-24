package com.example.Veteriner.Sistemi.bussines.abstracts;

import com.example.Veteriner.Sistemi.entities.Doctor;
import org.springframework.data.domain.Page;

// IDoctorService arayüzü, doktor yönetimi için gerekli hizmet yöntemlerini tanımlar.
public interface IDoctorService {

    // Yeni bir doktor kaydeder ve kaydedilen doktoru döner.
    Doctor save(Doctor doctor);

    // Belirtilen kimliğe sahip bir doktoru döner.
    Doctor get(long id);

    // Sayfalama yaparak belirli bir sayfa numarası ve sayfa boyutuna göre doktorları döner.
    Page<Doctor> cursor(int page, int pageSize);

    // Var olan bir doktoru günceller ve güncellenmiş doktoru döner.
    Doctor update(Doctor doctor);

    // Belirtilen kimliğe sahip bir doktoru siler ve başarılı olup olmadığını döner.
    boolean delete(long id);
}
