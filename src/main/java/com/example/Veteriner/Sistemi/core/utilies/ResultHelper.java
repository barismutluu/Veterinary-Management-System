package com.example.Veteriner.Sistemi.core.utilies;

import com.example.Veteriner.Sistemi.core.result.Result;
import com.example.Veteriner.Sistemi.core.result.ResultData;
import com.example.Veteriner.Sistemi.dto.response.CursorResponse;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

// Bu sınıf, genel işlemlerde sonuçları oluşturmak için yardımcı metodlar içerir.
public class ResultHelper {

    // Başarıyla oluşturulmuş bir kaydın sonucunu döndürür.
    public static <T> ResultData<T> created(T data) {
        return new ResultData<>(true, Msg.CREATED, "201", data);
    }

    // Doğrulama hatası sonucunu döndürür.
    public static <T> ResultData<T> validateError(T data) {
        return new ResultData<>(false, Msg.VALIDATE_ERROR, "400", data);
    }

    // Başarılı bir işlem sonucunu döndürür.
    public static Result ok(){
        return new Result(true,Msg.OK,"200");
    }

    // Başarılı bir işlem sonucunu ve veriyi döndürür.
    public static <T> ResultData<T> success(T data) {
        return new ResultData<>(true, Msg.OK, "200", data);
    }

    // Kayıt bulunamama hatası sonucunu döndürür.
    public static Result notFoundError(String msg) {
        return new Result(false, msg, "404");
    }

    // Sayfalı veri sonucunu döndürür.
    public static <T> ResultData<CursorResponse<T>> cursor(Page<T> pageData) {
        CursorResponse<T> cursor = new CursorResponse<>();
        cursor.setItems(pageData.getContent());
        cursor.setPageNumber(pageData.getNumber());
        cursor.setPageSize(pageData.getSize());
        cursor.setTotalElements(pageData.getTotalElements());
        return ResultHelper.success(cursor);
    }

    // HTTP 400 Bad Request hatası sonucunu döndürür.
    public static ResponseEntity<?> badRequest(String message) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
    }

    // Hata mesajı, veri ve HTTP durumuyla birlikte sonuç döndürür.
    public static <T> ResultData<T> errorWithData(String message, T data, HttpStatus status) {
        return new ResultData<>(false, message, status.value(), data);
    }
}
