package com.example.Veteriner.Sistemi.bussines.abstracts;

import com.example.Veteriner.Sistemi.dto.response.appointment.AppointmentResponse;
import com.example.Veteriner.Sistemi.entities.Animal;
import com.example.Veteriner.Sistemi.entities.Appointment;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

// IAppointmentService arayüzü, randevu yönetimi için gerekli hizmet yöntemlerini tanımlar.
public interface IAppointmentService {

    // Yeni bir randevu kaydeder ve kaydedilen randevuyu döner.
    Appointment save(Appointment appointment);

    // Belirtilen kimliğe sahip bir randevuyu döner.
    Appointment get(long id);

    // Sayfalama yaparak belirli bir sayfa numarası ve sayfa boyutuna göre randevuları döner.
    Page<Appointment> cursor(int page, int pageSize);

    // Var olan bir randevuyu günceller ve güncellenmiş randevuyu döner.
    Appointment update(Appointment appointment);

    // Belirtilen kimliğe sahip bir randevuyu siler ve başarılı olup olmadığını döner.
    boolean delete(long id);

    // Belirtilen tarih aralığında ve doktor kimliğine göre randevuları döner.
    List<Appointment> getAppointmentsByDateRangeAndDoctorId(LocalDate startDate, LocalDate endDate, Long doctorId);

    // Belirtilen tarih aralığında randevuları döner.
    List<Appointment> getAppointmentsByDateRange(LocalDate startDate, LocalDate endDate);

    // Belirtilen tarih aralığında ve hayvan kimliğine göre randevuları döner.
    List<Appointment> getAppointmentsByDateRangeAndAnimal(LocalDate startDate, LocalDate endDate, Long animalId);
}
