package com.example.Veteriner.Sistemi.dao;

// Spring Data JPA kullanılarak oluşturulan repository interface'i.
import com.example.Veteriner.Sistemi.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

// Gerekli Java zaman sınıflarını içe aktarır.
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

// Bu interface, Appointment entity sınıfı için JPA Repository'sini tanımlar.
@Repository
public interface AppointmentRepo extends JpaRepository<Appointment,Long> {
    // Verilen doktor kimliği ve randevu tarih saati ile bir randevunun var olup olmadığını kontrol eder.
    boolean existsByDoctorIdAndAppointmentDateTime(long doctorId, LocalDateTime appointmentDateTime);

    // Verilen doktor kimliği ve randevu tarih saati ile eşleşen tüm randevuları getirir.
    List<Appointment> findByDoctorIdAndAppointmentDateTime(long doctorId, LocalDateTime appointmentDateTime);

    // Verilen iki tarih arasındaki tüm randevuları getirir.
    List<Appointment> findByAppointmentDateTimeBetween(LocalDateTime startDateTime, LocalDateTime endDateTime);

    // Verilen doktor kimliği ve iki tarih arasındaki tüm randevuları getirir.
    List<Appointment> findByDoctorIdAndAppointmentDateTimeBetween(long doctorId, LocalDateTime startDate, LocalDateTime endDate);

    // Belirli bir tarih aralığı ve doktor kimliği ile eşleşen tüm randevuları getirir. Bu bir JPQL sorgusu kullanır.
    @Query("SELECT a FROM Appointment a WHERE a.appointmentDateTime >= :startDate AND a.appointmentDateTime <= :endDate AND a.doctor.id = :doctorId")
    List<Appointment> findByDateRangeAndDoctorId(@Param("startDate") LocalDateTime startDate,
                                                 @Param("endDate") LocalDateTime endDate,
                                                 @Param("doctorId") Long doctorId);

    // Verilen bir doktor kimliği ve iki tarih arasındaki tüm randevuları getirir.
    List<Appointment> getAppointmentsByDoctorIdAndAppointmentDateTimeBetween(Long doctorId, LocalDateTime startDate, LocalDateTime endDate);

    // Belirli bir hayvan kimliği ve iki tarih arasındaki tüm randevuları getirir.
    List<Appointment> findByAnimalIdAndAppointmentDateTimeBetween(Long animalId, LocalDateTime startDateTime, LocalDateTime endDateTime);
}
