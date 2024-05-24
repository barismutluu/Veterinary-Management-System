package com.example.Veteriner.Sistemi.dto.request.doctor;

// Lombok kütüphanesi kullanılarak oluşturulan getter, setter, equals, hashCode ve toString yöntemlerini otomatik olarak eklemek için gerekli annotasyonlar.
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Veteriner doktor bilgilerini güncellemek için kullanılan veri transfer nesnesi olarak işlev gören DoctorUpdateRequest sınıfı
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorUpdateRequest {
    // Veteriner doktorunun benzersiz kimliğini temsil eden alan
    private long id;

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
