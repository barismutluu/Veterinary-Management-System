package com.example.Veteriner.Sistemi.core.result;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class Result {
    private boolean status;
    private String message;
    private String code;
    private HttpStatus httpStatus;
    public Result(boolean status, String message, String code) {
        this.status = status;
        this.message = message;
        this.code = code;

    }

    public Result(boolean status, String message, HttpStatus httpStatus) {
        this.status = status;
        this.message = message;
        this.httpStatus = httpStatus;

    }


}
