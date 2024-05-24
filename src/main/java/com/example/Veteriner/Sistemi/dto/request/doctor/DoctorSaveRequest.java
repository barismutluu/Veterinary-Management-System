package com.example.Veteriner.Sistemi.dto.request.doctor;

// Lombok kütüphanesi kullanılarak oluşturulan getter, setter, equals, hashCode ve toString yöntemlerini otomatik olarak eklemek için gerekli annotasyonlar.
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Veteriner doktoru kaydetme isteğini temsil eden veri transfer nesnesi DoctorSaveRequest sınıfı
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorSaveRequest {

    // Veteriner doktorunun adını temsil eden alan
    private String name;

    // Veteriner doktorunun telefon numarasını temsil eden alan
    private String phone;

    // Veteriner doktorunun e-posta adresini temsil eden alan
    private String mail;

    // Veteriner doktorunun adresini temsil eden alan
    private String address;

    // Veteriner doktorunun bulunduğu şehri temsil eden alan
    private String city;
}
