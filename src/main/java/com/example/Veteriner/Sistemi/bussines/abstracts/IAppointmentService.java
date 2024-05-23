package com.example.Veteriner.Sistemi.bussines.abstracts;

import com.example.Veteriner.Sistemi.dto.response.appointment.AppointmentResponse;
import com.example.Veteriner.Sistemi.entities.Animal;
import com.example.Veteriner.Sistemi.entities.Appointment;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface IAppointmentService {
    Appointment save(Appointment appointment);

    Appointment get(long id);

    Page<Appointment> cursor(int page, int pageSize);

    Appointment update(Appointment appointment);

    boolean delete(long id);

    List<Appointment> getAppointmentsByDateRangeAndDoctorId(LocalDate startDate, LocalDate endDate, Long doctorId);
    List<Appointment> getAppointmentsByDateRange(LocalDate startDate, LocalDate endDate);
    List<Appointment> getAppointmentsByDateRangeAndAnimal(LocalDate startDate, LocalDate endDate, Long animalId);
}
