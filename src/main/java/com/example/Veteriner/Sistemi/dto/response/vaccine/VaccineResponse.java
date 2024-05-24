package com.example.Veteriner.Sistemi.dto.response.vaccine;

// Gerekli importlar
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

// VaccineResponse sınıfı tanımı
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VaccineResponse {

    // Aşının benzersiz kimliğini temsil eden bir uzun tamsayı
    private long id;

    // Aşının adını temsil eden bir dize
    private String name;

    // Aşının bir kodunu temsil eden bir dize
    private String code;

    // Aşının koruma sağlama başlangıç tarihini temsil eden bir LocalDate nesnesi
    private LocalDate protectionStartDate;

    // Aşının koruma sona erme tarihini temsil eden bir LocalDate nesnesi
    private LocalDate protectionFinishDate;

    // Aşının atanmış olduğu hayvanın kimliğini temsil eden bir uzun tamsayı
    private long animalId;
}
