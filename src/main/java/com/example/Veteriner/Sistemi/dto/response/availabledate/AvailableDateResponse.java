package com.example.Veteriner.Sistemi.dto.response.availabledate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvailableDateResponse {
    private long id;

    private String availableDate;
    private long doctorId;
}
