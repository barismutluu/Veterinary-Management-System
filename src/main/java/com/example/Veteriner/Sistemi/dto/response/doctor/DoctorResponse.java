package com.example.Veteriner.Sistemi.dto.response.doctor;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorResponse {
    private long id;

    private String name;

    private String phone;

    private String mail;

    private String address;

    private String city;
}
