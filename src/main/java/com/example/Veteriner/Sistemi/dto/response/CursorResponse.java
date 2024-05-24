package com.example.Veteriner.Sistemi.dto.response; // Bu sınıfın bulunduğu paketi belirtir.

import lombok.AllArgsConstructor; // Lombok kütüphanesinden @AllArgsConstructor özniteliğini ekler.
import lombok.Data; // Lombok kütüphanesinden @Data özniteliğini ekler.
import lombok.NoArgsConstructor; // Lombok kütüphanesinden @NoArgsConstructor özniteliğini ekler.
import java.util.List; // Java'nın List sınıfını ekler.

@Data // Lombok'tan gelen @Data özniteliği, getter, setter, toString, equals ve hashCode metodlarını otomatik olarak oluşturur.
@AllArgsConstructor // Lombok'tan gelen @AllArgsConstructor özniteliği, tüm alanlar için bir constructor oluşturur.
@NoArgsConstructor // Lombok'tan gelen @NoArgsConstructor özniteliği, argümansız bir constructor oluşturur.
public class CursorResponse<T> { // CursorResponse adında generic bir sınıf tanımlar.

    private int pageNumber; // Sayfa numarasını temsil eden bir private tamsayı alanı.
    private int pageSize; // Sayfa boyutunu temsil eden bir private tamsayı alanı.
    private long totalElements; // Toplam öğe sayısını temsil eden bir private uzun tamsayı alanı.
    private List<T> items; // T türündeki öğelerin bir listesini temsil eden bir private List alanı.

}
