package com.example.Veteriner.Sistemi.dto.response.appointment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentResponse {

    private long id;
    private LocalDateTime appointmentDateTime;
    private int animalId;
    private int doctorId;
}
