package com.example.Veteriner.Sistemi.dto.response.availabledate;

// Lombok kütüphanesi kullanılarak oluşturulan getter, setter, equals, hashCode ve toString yöntemlerini otomatik olarak eklemek için gerekli annotasyonlar.
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Veri transfer nesnesi olarak işlev gören AvailableDateResponse sınıfı
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvailableDateResponse {
    // Kullanılabilir tarihin benzersiz kimliğini temsil eden alan
    private long id;

    // Kullanılabilir tarihi depolayan alan
    private String availableDate;

    // Bu kullanılabilir tarihi sağlayan veteriner doktorunun kimliğini temsil eden alan
    private long doctorId;
}
