package com.example.Veteriner.Sistemi.dto.request.appointment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentSaveRequest {

    private LocalDateTime appointmentDateTime;
    private int animalId;
    private int doctorId;
}
