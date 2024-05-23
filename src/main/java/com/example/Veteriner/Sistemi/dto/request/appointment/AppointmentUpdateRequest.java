package com.example.Veteriner.Sistemi.dto.request.appointment;

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentUpdateRequest {
    @Positive
    private long id;
    private LocalDateTime appointmentDateTime;
    private int animalId;
    private int doctorId;
}
