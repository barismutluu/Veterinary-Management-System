package com.example.Veteriner.Sistemi.dto.request.availabledate;

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvailableDateUpdateRequest {
    @Positive
    private long id;
    private LocalDate availableDate;
    private long doctorId;
}
