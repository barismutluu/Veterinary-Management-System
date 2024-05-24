package com.example.Veteriner.Sistemi.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
@Entity
@Table(name = "animals") // "animals" adında bir tabloya karşılık gelir
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Otomatik artan bir kimlik alanı
    @Column(name = "animal_id",columnDefinition = "serial") // Veritabanında "animal_id" olarak saklanır, "serial" tipinde
    private long id;

    @NotNull // Null olamaz
    @Column(name = "animal_name") // Veritabanında "animal_name" olarak saklanır
    private String name;

    @NotNull // Null olamaz
    @Column(name = "animal_species") // Veritabanında "animal_species" olarak saklanır
    private String species;

    @NotNull // Null olamaz
    @Column(name = "animal_breed") // Veritabanında "animal_breed" olarak saklanır
    private String breed;

    @NotNull // Null olamaz
    @Column(name = "animal_gender") // Veritabanında "animal_gender" olarak saklanır
    private String gender;

    @NotNull // Null olamaz
    @Column(name = "animal_colour") // Veritabanında "animal_colour" olarak saklanır
    private String colour;

    @NotNull // Null olamaz
    @Column(name = "animal_dateOfBirth") // Veritabanında "animal_dateOfBirth" olarak saklanır
    private LocalDate dateOfBirth;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "customer_id", referencedColumnName="customer_id") // "customer_id" sütunuyla ilişkilendirilmiş
    private Customer customer;

    @OneToMany(mappedBy = "animal",cascade = CascadeType.REMOVE) // Bir hayvanın birden çok aşısı olabilir
    private List<Vaccine> vaccines;

    @OneToMany(mappedBy = "animal",cascade = CascadeType.REMOVE) // Bir hayvanın birden çok randevusu olabilir
    private List<Appointment> appointments;
}
