package com.example.Veteriner.Sistemi.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "customers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id",columnDefinition = "serial")
    private long id;
    @NotNull
    @Column(name = "customer_name")
    private String name;
    @NotNull
    @Column(name = "customer_phone")
    private String phone;
    @NotNull
    @Email
    @Column(name = "customer_mail")
    private String mail;
    @NotNull
    @Column(name = "customer_address")
    private String address;
    @NotNull
    @Column(name = "customer_city")
    private String city;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "customer")
    private List<Animal> animals;
}
