package com.example.Veteriner.Sistemi.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "appointment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointment_id",columnDefinition = "serial")
    private long id;

    @NotNull
    @Column(name = "appointmentDateTime")
    private LocalDateTime appointmentDateTime;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "animal_id", referencedColumnName="animal_id")
    private Animal animal;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "doctor_id", referencedColumnName="doctor_id")
    private Doctor doctor;


}
