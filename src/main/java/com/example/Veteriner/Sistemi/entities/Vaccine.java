package com.example.Veteriner.Sistemi.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "vaccine")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vaccine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vaccine_id",columnDefinition = "serial")
    private long id;
    // @NotNull
    @Column(name = "vaccine_name")
    private String name;
    // @NotNull
    @Column(name = "vaccine_code")
    private String code;
    //@NotNull
    @Column(name = "avaccine_protectionStartDate")
    private LocalDate protectionStartDate;
    //@NotNull

    @Column(name = "vaccine_protectionFinishDate")
    private LocalDate protectionFinishDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "animal_id", referencedColumnName="animal_id")
    private Animal animal;

}
