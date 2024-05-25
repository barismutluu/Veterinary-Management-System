package com.example.Veteriner.Sistemi.entities;

// Gerekli paketlerin import edilmesi

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

// Bu sınıfın bir JPA varlığı (entity) olduğunu belirtiyor
@Entity
// Veritabanında bu varlık için oluşturulacak tablonun adını belirtiyor
@Table(name = "doctors")
// Lombok kütüphanesinin sağladığı, getter ve setter gibi metotların otomatik oluşturulmasını sağlayan anotasyon
@Data
// Lombok kütüphanesinin sağladığı, tüm alanları parametre olarak alan bir constructor oluşturulmasını sağlayan anotasyon
@AllArgsConstructor
// Lombok kütüphanesinin sağladığı, parametresiz bir constructor oluşturulmasını sağlayan anotasyon
@NoArgsConstructor
public class Doctor {
    // Bu alanın veritabanında birincil anahtar (primary key) olduğunu belirtiyor
    @Id
    // Bu alanın otomatik olarak artan bir değerle doldurulacağını belirtiyor
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Bu alanın veritabanında hangi sütun ile eşleşeceğini belirtiyor ve sütun tanımını yapıyor
    @Column(name = "doctor_id", columnDefinition = "serial")
    private long id;

    // Bu alanın boş olamayacağını belirtiyor
    @NotNull
    // Bu alanın veritabanında hangi sütun ile eşleşeceğini belirtiyor
    @Column(name = "doctor_name")
    private String name;

    @NotNull
    @Column(name = "doctor_phone")
    private String phone;

    @NotNull
    @Column(name = "doctor_mail")
    private String mail;

    @NotNull
    @Column(name = "doctor_address")
    private String address;

    @NotNull
    @Column(name = "doctor_city")
    private String city;

    // Bu alanın birden fazla AvailableDate nesnesi ile ilişkilendirileceğini belirtiyor
    // CascadeType ile bu varlıkla ilgili tüm değişikliklerin ilişkili varlıklara da uygulanacağını belirtir
    // mappedBy ile bu ilişkiyi sahiplenen tarafın AvailableDate sınıfında "doctor" alanı olduğunu belirtiyor
    @OneToMany(mappedBy = "doctor", cascade = CascadeType.REMOVE)
    private List<AvailableDate> availableDates;

    // Bu alanın birden fazla Appointment nesnesi ile ilişkilendirileceğini belirtiyor
    // CascadeType ile bu varlıkla ilgili tüm değişikliklerin ilişkili varlıklara da uygulanacağını belirtir
    // mappedBy ile bu ilişkiyi sahiplenen tarafın Appointment sınıfında "doctor" alanı olduğunu belirtiyor
    @OneToMany(mappedBy = "doctor", cascade = CascadeType.REMOVE)
    private List<Appointment> appointments;
}
