package com.example.Veteriner.Sistemi.entities;

// Gerekli kütüphanelerin import edilmesi
import jakarta.persistence.*; // JPA (Java Persistence API) için gerekli kütüphaneler
import jakarta.validation.constraints.Email; // Email doğrulama için gerekli kütüphane
import jakarta.validation.constraints.NotNull; // Null olmama koşulunu sağlamak için gerekli kütüphane
import lombok.AllArgsConstructor; // Tüm argümanları içeren bir constructor oluşturmak için Lombok anotasyonu
import lombok.Data; // Getter, Setter, ToString, EqualsAndHashCode ve RequiredArgsConstructor oluşturmak için Lombok anotasyonu
import lombok.NoArgsConstructor; // Parametresiz bir constructor oluşturmak için Lombok anotasyonu

import java.util.List; // List veri yapısını kullanmak için gerekli kütüphane

// JPA Entity olarak işaretleme
@Entity
// Veritabanında "customers" adlı tablo ile eşleştirme
@Table(name = "customers")
// Lombok anotasyonları
@Data // Getter, Setter, ToString, EqualsAndHashCode ve RequiredArgsConstructor metodlarını otomatik oluşturur
@AllArgsConstructor // Tüm argümanları içeren constructor oluşturur
@NoArgsConstructor // Parametresiz constructor oluşturur
public class Customer {
    // Primary key alanı ve otomatik artan değer stratejisi ile ayarlanması
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id", columnDefinition = "serial")
    private long id;

    // İsim alanının null olmama koşulu ve veritabanındaki sütun adı ile eşleştirilmesi
    @NotNull
    @Column(name = "customer_name")
    private String name;

    // Telefon alanının null olmama koşulu ve veritabanındaki sütun adı ile eşleştirilmesi
    @NotNull
    @Column(name = "customer_phone")
    private String phone;

    // E-posta alanının null olmama ve e-posta formatında olma koşulu ile veritabanındaki sütun adı ile eşleştirilmesi
    @NotNull
    @Email
    @Column(name = "customer_mail")
    private String mail;

    // Adres alanının null olmama koşulu ve veritabanındaki sütun adı ile eşleştirilmesi
    @NotNull
    @Column(name = "customer_address")
    private String address;

    // Şehir alanının null olmama koşulu ve veritabanındaki sütun adı ile eşleştirilmesi
    @NotNull
    @Column(name = "customer_city")
    private String city;

    // Bir müşteri birden fazla hayvana sahip olabilir ilişkisinin tanımlanması (OneToMany)
    // CascadeType.REMOVE: Müşteri üzerinde yapılan her işlem (örneğin silme), ilişkili hayvanlar üzerinde de uygulanır
    // mappedBy: "customer" alanı, hayvanlar tablosundaki ilişkili alanın adıdır
    @OneToMany(mappedBy = "customer",cascade = CascadeType.REMOVE)
    private List<Animal> animals;
}
