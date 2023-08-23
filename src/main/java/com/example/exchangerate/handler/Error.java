package com.example.exchangerate.handler;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Error {

    private String code;
    private String status;
    private String message;
}
