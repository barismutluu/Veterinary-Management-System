package com.example.Veteriner.Sistemi.dao;

import com.example.Veteriner.Sistemi.entities.Appointment;
import com.example.Veteriner.Sistemi.entities.AvailableDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment,Long> {
    boolean existsByDoctorIdAndAppointmentDateTime(long doctorId, LocalDateTime appointmentDateTime);
    List<Appointment> findByDoctorIdAndAppointmentDateTime(long doctorId, LocalDateTime appointmentDateTime);
    List<Appointment> findByAppointmentDateTimeBetween(LocalDateTime startDateTime, LocalDateTime endDateTime);
    List<Appointment> findByDoctorIdAndAppointmentDateTimeBetween(long doctorId, LocalDateTime startDate, LocalDateTime endDate);
    @Query("SELECT a FROM Appointment a WHERE a.appointmentDateTime >= :startDate AND a.appointmentDateTime <= :endDate AND a.doctor.id = :doctorId")
    List<Appointment> findByDateRangeAndDoctorId(@Param("startDate") LocalDateTime startDate,
                                                 @Param("endDate") LocalDateTime endDate,
                                                 @Param("doctorId") Long doctorId);
    List<Appointment> getAppointmentsByDoctorIdAndAppointmentDateTimeBetween(Long doctorId, LocalDateTime startDate, LocalDateTime endDate);

    List<Appointment> findByAnimalIdAndAppointmentDateTimeBetween(Long animalId, LocalDateTime startDateTime, LocalDateTime endDateTime);
}
