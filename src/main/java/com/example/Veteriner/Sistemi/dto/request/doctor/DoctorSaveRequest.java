package com.example.Veteriner.Sistemi.dto.request.doctor;

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorSaveRequest {

    private String name;

    private String phone;

    private String mail;

    private String address;

    private String city;
}
