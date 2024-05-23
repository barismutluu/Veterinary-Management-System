package com.example.Veteriner.Sistemi.dto.request.doctor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorUpdateRequest {
    private long id;

    private String name;

    private String phone;

    private String mail;

    private String address;

    private String city;

}
