package com.example.Veteriner.Sistemi.dto.response.doctor;

// Lombok kütüphanesinden gelen annotasyonlar, getter, setter, equals, hashCode ve toString yöntemlerini otomatik olarak ekler.
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Veri transfer nesnesi olarak işlev gören DoctorResponse sınıfı
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorResponse {
    // Doktorun benzersiz kimliğini temsil eden alan
    private long id;

    // Doktorun adını temsil eden alan
    private String name;

    // Doktorun telefon numarasını temsil eden alan
    private String phone;

    // Doktorun e-posta adresini temsil eden alan
    private String mail;

    // Doktorun adresini temsil eden alan
    private String address;

    // Doktorun bulunduğu şehri temsil eden alan
    private String city;
}
