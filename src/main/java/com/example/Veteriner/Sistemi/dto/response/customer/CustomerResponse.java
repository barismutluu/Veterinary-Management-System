package com.example.Veteriner.Sistemi.dto.response.customer;

// Lombok kütüphanesi kullanılarak otomatik olarak getter, setter, equals, hashCode ve toString yöntemlerini oluşturmak için gerekli annotasyonlar.
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Müşteriye yanıt olarak döndürülen veri transfer nesnesi
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponse {
    // Müşterinin benzersiz kimliğini temsil eden alan
    private long id;

    // Müşterinin adını temsil eden alan
    private String name;

    // Müşterinin telefon numarasını temsil eden alan
    private String phone;

    // Müşterinin e-posta adresini temsil eden alan
    private String mail;

    // Müşterinin adresini temsil eden alan
    private String address;

    // Müşterinin bulunduğu şehri temsil eden alan
    private String city;
}
