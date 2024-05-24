package com.example.Veteriner.Sistemi.core.utilies;

// Bu sınıf, uygulama içinde kullanılacak sabit mesajları tanımlar.
public class Msg {
    // Yeni bir kaydın başarıyla eklendiğini belirten mesaj.
    public static final String CREATED = "Kayıt Eklendi";

    // İşlemin başarıyla gerçekleştirildiğini belirten genel mesaj.
    public static final String OK = "İşlem Başarılı";

    // Kayıt doğrulamasının başarısız olduğunu belirten hata mesajı.
    public static final String VALIDATE_ERROR = "Kayıt Doğrulama Hatası";

    // Aranan verinin bulunamadığını belirten hata mesajı.
    public static final String NOT_FOUND = "Veri Bulunamadı";

    // Belirli bir aşı türü için koruyuculuk bitmediği durumda yeni bir aşı eklenemeyeceğini belirten hata mesajı.
    public static final String BAD_REQUEST = "Bu tip aşı için henüz koruyuculuk bitmemiştir. Yeni aşı giremezsiniz.";
}
