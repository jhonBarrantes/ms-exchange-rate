package com.example.exchangerate.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;


@RestControllerAdvice
@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(Exception.class)
  public final ResponseEntity<Error> handleAllExceptions(Exception ex, WebRequest request) {
    Error errorResponse = new Error();
    errorResponse.setCode(HttpStatus.INTERNAL_SERVER_ERROR.name());
    errorResponse.setStatus(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
    errorResponse.setMessage(request.getDescription(false));
    return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(ResponseStatusException.class)
  public final ResponseEntity<Error> handleHttpExceptions(Exception ex, WebRequest request){
    Error errorResponse = new Error();
    ErrorEnum errorEnum = ErrorEnum.valueOfs(ex.getCause().getMessage());
    if(errorEnum != null){
      errorResponse.setCode(errorEnum.code);
    }else {
      errorResponse.setCode("500");
    }

    return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
  }


}
