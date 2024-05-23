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

@Service
public class DoctorManager implements IDoctorService {
    private final DoctorRepo doctorRepo;
    private final AppointmentRepo appointmentRepo;

    public DoctorManager(DoctorRepo doctorRepo, AppointmentRepo appointmentRepo) {
        this.doctorRepo = doctorRepo;
        this.appointmentRepo = appointmentRepo;
    }


    @Override
    public Doctor save(Doctor doctor) {
        return this.doctorRepo.save(doctor);
    }

    @Override
    public Doctor get(long id) {
        return this.doctorRepo.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
    }
    public boolean existsById(long id) {
        return doctorRepo.existsById(id);
    }


    @Override
    public Page<Doctor> cursor(int page, int pageSize) {
        Pageable pageable= PageRequest.of(page, pageSize);
        return this.doctorRepo.findAll(pageable);
    }

    public boolean isDoctorAvailableOnDate(long doctorId, LocalDateTime dateTime) {
        // Doktorun belirtilen tarihte çalışıp çalışmadığını kontrol eden kodu ekle
        // Örneğin, haftanın belirli günleri çalışıyor olabilir.
        // Basit bir kontrol: doktor haftasonu çalışmıyor
        int dayOfWeek = dateTime.getDayOfWeek().getValue();
        return dayOfWeek != 6 && dayOfWeek != 7; // Cumartesi ve Pazar günleri çalışmıyor
    }

    public boolean hasDoctorAppointmentAtTime(long doctorId, LocalDateTime dateTime) {
        List<Appointment> appointments = appointmentRepo.findByDoctorIdAndAppointmentDateTime(doctorId, dateTime);
        return !appointments.isEmpty();
    }

    @Override
    public Doctor update(Doctor doctor) {
        this.get(doctor.getId());
        return this.doctorRepo.save(doctor);
    }

    @Override
    public boolean delete(long id) {
        Doctor doctor=this.get(id);
        this.doctorRepo.delete(doctor);
        return true;
    }
}
