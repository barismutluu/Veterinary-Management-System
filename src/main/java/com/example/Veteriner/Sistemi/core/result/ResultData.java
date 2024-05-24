package com.example.Veteriner.Sistemi.core.result;

import lombok.Getter;

@Getter
// Bu sınıf, bir sonuç nesnesini temsil eder ve bu sonuç nesnesi veri taşır.
public class ResultData<T> extends Result {

    // Sonuç nesnesi veri taşıyan generic bir veri alanına sahiptir.
    private T data;

    // Parametre olarak status (durum), message (mesaj), code (kod) ve data (veri) alanları alarak ResultData nesnesi oluşturur.
    public ResultData(boolean status, String message, String code, T data) {
        // Üst sınıfın (Result) constructor'ını çağırarak durum, mesaj ve kodu ayarlar.
        super(status, message, code);
        // Veri alanını parametre olarak alınan veri ile ayarlar.
        this.data = data;
    }

    // Parametre olarak status (durum), message (mesaj), code (kod) ve data (veri) alanları alarak ResultData nesnesi oluşturur.
    // Burada code parametresi bir tamsayı olarak alınır.
    public ResultData(boolean status, String message, int code, T data) {
        // Üst sınıfın (Result) constructor'ını çağırarak durum, mesaj ve kodu ayarlar.
        // Kodu string olarak ayarlamak için String.valueOf() metodu kullanılır.
        super(status, message, String.valueOf(code));
        // Veri alanını parametre olarak alınan veri ile ayarlar.
        this.data = data;
    }
}
