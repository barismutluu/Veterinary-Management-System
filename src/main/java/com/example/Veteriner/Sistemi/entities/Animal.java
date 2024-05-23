package com.example.Veteriner.Sistemi.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "animals")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "animal_id",columnDefinition = "serial")
    private long id;

    @NotNull
    @Column(name = "animal_name")
    private String name;
    @NotNull
    @Column(name = "animal_species")
    private String species;
    @NotNull
    @Column(name = "animal_breed")
    private String breed;
    @NotNull
    @Column(name = "animal_gender")
    private String gender;
    @NotNull
    @Column(name = "animal_colour")
    private String colour;

    @NotNull
    @Column(name = "animal_dateOfBirth")
    private LocalDate dateOfBirth;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", referencedColumnName="customer_id")
    private Customer customer;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "animal")
    private List<Vaccine> vaccines;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "animal")
    private List<Appointment> appointments;


}
