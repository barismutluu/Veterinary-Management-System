package com.example.Veteriner.Sistemi.core.exception;

// Bu sınıf, doktorun uygun olmadığı bir durumda atılacak özel bir istisna sınıfını tanımlar.
public class DoctorAvailabilityException extends RuntimeException {

    // Oluşturucu metod, istisna mesajını alarak üst sınıfa iletir.
    public DoctorAvailabilityException(String message) {
        super(message);
    }
}
