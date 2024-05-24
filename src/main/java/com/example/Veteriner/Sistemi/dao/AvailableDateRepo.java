package com.example.Veteriner.Sistemi.dao; // Bu sınıfın paketi, bu dosyanın bulunduğu dizini temsil eder.

import com.example.Veteriner.Sistemi.entities.Animal; // Hayvan sınıfının bulunduğu paketi içeri aktarıyoruz.
import com.example.Veteriner.Sistemi.entities.AvailableDate; // AvailableDate sınıfının bulunduğu paketi içeri aktarıyoruz.
import org.springframework.data.jpa.repository.JpaRepository; // JpaRepository arayüzünü içeri aktarıyoruz.
import org.springframework.stereotype.Repository; // Repository annotation'ını içeri aktarıyoruz.

@Repository // Bu sınıfın bir Spring bileşeni olduğunu belirtir, genellikle veri erişim sınıflarına uygulanır.
public interface AvailableDateRepo extends JpaRepository<AvailableDate,Long> {
    // AvailableDateRepo, JpaRepository arayüzünden kalıtım alır ve AvailableDate nesnelerini yönetir.
    // AvailableDate tipi için bir kimlik tipi olarak Long kullanılır.
}
