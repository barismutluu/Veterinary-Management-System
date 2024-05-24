package com.example.Veteriner.Sistemi.core.exception;

// Bu sınıf, belirli bir kaydın bulunamadığı durumda fırlatılacak özel bir istisna (exception) sınıfını tanımlar.
public class NotFoundException extends RuntimeException {
    // Belirli bir mesajla birlikte NotFoundException nesnesi oluşturulduğunda bu mesajı içeren bir istisna oluşturulur.
    public NotFoundException(String message) {
        super(message);
    }
}
