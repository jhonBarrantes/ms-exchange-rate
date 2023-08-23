package com.example.exchangerate.handler;

import java.util.Arrays;

public enum ErrorEnum {
    ERROR_500("E500", "No se encontró tipo de cambio para las monedas específicas" );
    public String code;
    public String message;

    private ErrorEnum(String code, String message){
        this.code = code;
        this.message = message;
    }

    public static ErrorEnum valueOfs(String code){
        return Arrays.stream(ErrorEnum.values()).filter(error -> error.code.equalsIgnoreCase(code)).findFirst().orElse(null);
    }
}
