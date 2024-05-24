package com.example.Veteriner.Sistemi.dao; // Bu satır, Java sınıflarının bulunduğu paketi belirtir.

import com.example.Veteriner.Sistemi.entities.Doctor; // Bu satır, Doctor sınıfını bu Java sınıfında kullanabilmek için com.example.Veteriner.Sistemi.entities paketinden içe aktarır.
import org.springframework.data.jpa.repository.JpaRepository; // Spring Data JPA tarafından sağlanan JpaRepository arabirimini içeri aktarır. Bu arabirim, veritabanı işlemleri yapmak için kullanılır.
import org.springframework.stereotype.Repository; // Bu satır, bu sınıfın bir Spring bileşeni olduğunu belirtmek için @Repository anotasyonunu içeri aktarır.

@Repository // Bu anotasyon, bu sınıfın bir Spring bileşeni olduğunu belirtir. Bu, sınıfın otomatik olarak tarama ve ilgili yerlere enjekte edilmesini sağlar.
public interface DoctorRepo extends JpaRepository<Doctor, Long> { // DoctorRepo adında bir arayüz tanımlar. Bu arayüz, JpaRepository arabirimini genişletir ve Doctor varlık sınıfını ve onun kimlik alanını (Long) kullanır. Bu arayüz, Doctor varlığı için temel CRUD (Create, Read, Update, Delete) işlemlerini yapmak için kullanılabilir. Bu işlemler otomatik olarak Spring Data JPA tarafından sağlanır.
}
