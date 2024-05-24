package com.example.Veteriner.Sistemi.core.result;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
// Bu sınıf, API çağrılarının sonuçlarını temsil eder.
public class Result {
    private boolean status; // İşlemin başarılı olup olmadığını belirten boolean değer.
    private String message; // İşlemle ilgili mesajı içeren metin.
    private String code; // İşlemle ilişkilendirilen kod.
    private HttpStatus httpStatus; // HTTP yanıt durumunu temsil eden enum.

    // İşlemin başarısı, mesaj ve kod bilgisiyle sonuç döndüren constructor.
    public Result(boolean status, String message, String code) {
        this.status = status;
        this.message = message;
        this.code = code;
    }

    // İşlemin başarısı, mesaj ve HTTP durumuyla sonuç döndüren constructor.
    public Result(boolean status, String message, HttpStatus httpStatus) {
        this.status = status;
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
