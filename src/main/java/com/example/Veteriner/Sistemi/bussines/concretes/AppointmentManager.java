package com.example.Veteriner.Sistemi.bussines.concretes;

import com.example.Veteriner.Sistemi.bussines.abstracts.IAnimalService;
import com.example.Veteriner.Sistemi.bussines.abstracts.IAppointmentService;
import com.example.Veteriner.Sistemi.core.exception.DoctorAvailabilityException;
import com.example.Veteriner.Sistemi.core.exception.NotFoundException;
import com.example.Veteriner.Sistemi.core.utilies.Msg;
import com.example.Veteriner.Sistemi.dao.AnimalRepo;
import com.example.Veteriner.Sistemi.dao.AppointmentRepo;
import com.example.Veteriner.Sistemi.dao.DoctorRepo;
import com.example.Veteriner.Sistemi.dto.response.appointment.AppointmentResponse;
import com.example.Veteriner.Sistemi.entities.Animal;
import com.example.Veteriner.Sistemi.entities.Appointment;
import com.example.Veteriner.Sistemi.entities.Doctor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

// Bu sınıf, randevularla ilgili iş mantığını yürütür.
@Service
public class AppointmentManager implements IAppointmentService {
    private final AppointmentRepo appointmentRepo;
    private final AnimalManager animalManager;
    private final DoctorManager doctorManager;
    private final DoctorRepo doctorRepo;
    private final AnimalRepo animalRepo;

    public AppointmentManager(AppointmentRepo appointmentRepo, AnimalManager animalManager, DoctorManager doctorManager, DoctorRepo doctorRepo, AnimalRepo animalRepo) {
        this.appointmentRepo = appointmentRepo;
        this.animalManager = animalManager;
        this.doctorManager = doctorManager;
        this.doctorRepo = doctorRepo;
        this.animalRepo = animalRepo;
    }

    // Belirli bir tarih aralığında randevuları getirir.
    @Override
    public List<Appointment> getAppointmentsByDateRange(LocalDate startDate, LocalDate endDate) {
        LocalDateTime startDateTime = startDate.atStartOfDay();
        LocalDateTime endDateTime = endDate.atTime(LocalTime.MAX);
        return appointmentRepo.findByAppointmentDateTimeBetween(startDateTime, endDateTime);
    }

    // Belirli bir tarih aralığında ve belirli bir hayvan için randevuları getirir.
    @Override
    public List<Appointment> getAppointmentsByDateRangeAndAnimal(LocalDate startDate, LocalDate endDate, Long animalId) {
        LocalDateTime startDateTime = startDate.atStartOfDay();
        LocalDateTime endDateTime = endDate.atTime(LocalTime.MAX);
        return appointmentRepo.findByAnimalIdAndAppointmentDateTimeBetween(animalId, startDateTime, endDateTime);
    }

    // Belirli bir tarih aralığında ve belirli bir doktor için randevuları getirir.
    @Override
    public List<Appointment> getAppointmentsByDateRangeAndDoctorId(LocalDate startDate, LocalDate endDate, Long doctorId) {
        LocalDateTime startDateTime = LocalDateTime.of(startDate, LocalTime.MIDNIGHT);
        LocalDateTime endDateTime = LocalDateTime.of(endDate, LocalTime.of(23, 59, 59));
        return appointmentRepo.findByDateRangeAndDoctorId(startDateTime, endDateTime, doctorId);
    }

    // Doktorun belirtilen tarihte müsait olup olmadığını kontrol eder.
    public boolean isDoctorAvailableOnDate(long doctorId, LocalDateTime dateTime) {
        int dayOfWeek = dateTime.getDayOfWeek().getValue();
        return dayOfWeek != 6 && dayOfWeek != 7; // Cumartesi ve Pazar günleri çalışmıyor
    }

    // Doktorun belirtilen saatte başka bir randevusu olup olmadığını kontrol eder.
    public boolean hasDoctorAppointmentAtTime(long doctorId, LocalDateTime dateTime) {
        List<Appointment> appointments = appointmentRepo.findByDoctorIdAndAppointmentDateTime(doctorId, dateTime);
        return !appointments.isEmpty();
    }

    // Yeni bir randevu kaydı oluşturur.
    @Override
    public Appointment save(Appointment appointment) {
        if (appointment.getAppointmentDateTime().getMinute() != 0 || appointment.getAppointmentDateTime().getSecond() != 0) {
            throw new IllegalArgumentException("Randevular sadece saat başlarında yapılabilir.");
        }

        Doctor doctor = doctorRepo.findById(appointment.getDoctor().getId())
                .orElseThrow(() -> new NotFoundException("Doktor bulunamadı"));
        Animal animal = animalRepo.findById(appointment.getAnimal().getId())
                .orElseThrow(() -> new NotFoundException("Hayvan bulunamadı"));

        appointment.setDoctor(doctor);
        appointment.setAnimal(animal);

        if (appointmentRepo.existsByDoctorIdAndAppointmentDateTime(appointment.getDoctor().getId(), appointment.getAppointmentDateTime())) {
            throw new IllegalArgumentException("Doktorun bu saatte zaten bir randevusu var.");
        }

        return appointmentRepo.save(appointment);
    }

    // Belirli bir randevuyu getirir.
    @Override
    public Appointment get(long id) {
        return this.appointmentRepo.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
    }

    // Sayfalama işlemi ile randevuları getirir.
    @Override
    public Page<Appointment> cursor(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return this.appointmentRepo.findAll(pageable);
    }

    // Bir randevuyu günceller.
    @Override
    public Appointment update(Appointment appointment) {
        this.get(appointment.getId());
        checkAnimalExists(appointment.getAnimal().getId());
        checkAnimalExists(appointment.getDoctor().getId());
        return this.appointmentRepo.save(appointment);
    }

    // Bir randevuyu siler.
    @Override
    public boolean delete(long id) {
        Appointment appointment = this.get(id);
        this.appointmentRepo.delete(appointment);
        return true;
    }

    // Hayvanın var olup olmadığını kontrol eder.
    private void checkAnimalExists(long animalId) {
        if (!animalManager.existsById(animalId)) {
            throw new NotFoundException(Msg.NOT_FOUND);
        }
    }

    // Doktorun belirli bir tarihte müsait olup olmadığını kontrol eder.
    private void checkDoctorAvailability(long doctorId, LocalDateTime dateTime) {
        if (!doctorManager.isDoctorAvailableOnDate(doctorId, dateTime)) {
            throw new DoctorAvailabilityException("Doktor bu tarihte çalışmamaktadır!");
        }
        if (doctorManager.hasDoctorAppointmentAtTime(doctorId, dateTime)) {
            throw new DoctorAvailabilityException("Girilen saatte başka bir randevu mevcuttur.");
        }
    }
}
