package com.example.Veteriner.Sistemi.core.result;

import lombok.Getter;

@Getter
public class ResultData<T> extends Result {

    private T data;

    public ResultData(boolean status, String message, String code, T data) {
        super(status, message, code);
        this.data = data;
    }

    public ResultData(boolean status, String message, int code, T data) {
        super(status, message, String.valueOf(code));
        this.data = data;
    }
}
