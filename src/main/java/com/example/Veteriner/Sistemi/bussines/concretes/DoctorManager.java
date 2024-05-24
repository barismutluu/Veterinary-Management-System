package com.example.Veteriner.Sistemi.bussines.concretes;

import com.example.Veteriner.Sistemi.bussines.abstracts.ICustomerService;
import com.example.Veteriner.Sistemi.bussines.abstracts.IDoctorService;
import com.example.Veteriner.Sistemi.core.exception.NotFoundException;
import com.example.Veteriner.Sistemi.core.utilies.Msg;
import com.example.Veteriner.Sistemi.dao.AppointmentRepo;
import com.example.Veteriner.Sistemi.dao.DoctorRepo;
import com.example.Veteriner.Sistemi.entities.Appointment;
import com.example.Veteriner.Sistemi.entities.Doctor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

// Bu sınıf, IDoctorService arayüzünü uygular ve doktor işlemlerini yönetir.
@Service
public class DoctorManager implements IDoctorService {
    private final DoctorRepo doctorRepo;
    private final AppointmentRepo appointmentRepo;

    // DoctorManager sınıfının yapıcı metodu, DoctorRepo ve AppointmentRepo bağımlılıklarını enjekte eder.
    public DoctorManager(DoctorRepo doctorRepo, AppointmentRepo appointmentRepo) {
        this.doctorRepo = doctorRepo;
        this.appointmentRepo = appointmentRepo;
    }

    // Doktoru kaydeder.
    @Override
    public Doctor save(Doctor doctor) {
        return this.doctorRepo.save(doctor);
    }

    // Belirtilen kimlik numarasına sahip doktoru getirir, eğer bulunamazsa bir NotFound istisnası fırlatır.
    @Override
    public Doctor get(long id) {
        return this.doctorRepo.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
    }

    // Belirtilen kimlik numarasına sahip doktorun mevcut olup olmadığını kontrol eder.
    public boolean existsById(long id) {
        return doctorRepo.existsById(id);
    }

    // Sayfa numarası ve sayfa boyutu verilen sayfa sorgusuna göre doktorları getirir.
    @Override
    public Page<Doctor> cursor(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return this.doctorRepo.findAll(pageable);
    }

    // Belirtilen tarih ve saatte doktorun uygun olup olmadığını kontrol eder.
    public boolean isDoctorAvailableOnDate(long doctorId, LocalDateTime dateTime) {
        // Doktorun belirtilen tarihte çalışıp çalışmadığını kontrol eden kodu ekle
        // Örneğin, haftanın belirli günleri çalışıyor olabilir.
        // Basit bir kontrol: doktor haftasonu çalışmıyor
        int dayOfWeek = dateTime.getDayOfWeek().getValue();
        return dayOfWeek != 6 && dayOfWeek != 7; // Cumartesi ve Pazar günleri çalışmıyor
    }

    // Belirtilen tarih ve saatte doktorun randevusu olup olmadığını kontrol eder.
    public boolean hasDoctorAppointmentAtTime(long doctorId, LocalDateTime dateTime) {
        List<Appointment> appointments = appointmentRepo.findByDoctorIdAndAppointmentDateTime(doctorId, dateTime);
        return !appointments.isEmpty();
    }

    // Doktor bilgilerini günceller.
    @Override
    public Doctor update(Doctor doctor) {
        this.get(doctor.getId());
        return this.doctorRepo.save(doctor);
    }

    // Belirtilen kimlik numarasına sahip doktoru siler.
    @Override
    public boolean delete(long id) {
        Doctor doctor = this.get(id);
        this.doctorRepo.delete(doctor);
        return true;
    }
}
