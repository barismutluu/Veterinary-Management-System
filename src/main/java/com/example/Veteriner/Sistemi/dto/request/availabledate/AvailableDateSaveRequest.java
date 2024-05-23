package com.example.Veteriner.Sistemi.dto.request.availabledate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvailableDateSaveRequest {
    private LocalDate availableDate;
    private long doctorId;
}
