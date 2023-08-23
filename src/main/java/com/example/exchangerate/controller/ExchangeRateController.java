package com.example.exchangerate.controller;

import com.example.exchangerate.models.Input;
import com.example.exchangerate.models.Output;
import com.example.exchangerate.service.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

@RestController
public class ExchangeRateController {

  @Autowired
  ExchangeRateService exchangeRateService;

  @PostMapping("/exchange")
  public Mono<Output> exchangeRate(@RequestBody Input input){
    try{
      return exchangeRateService.exchangeRate(input);
    }catch(Exception ex) {
      throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED, "Exception", ex);
    }
  }
}
