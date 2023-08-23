package com.example.exchangerate.service;

import com.example.exchangerate.models.Input;
import com.example.exchangerate.models.Output;
import reactor.core.publisher.Mono;


public interface ExchangeRateService {

  public Mono<Output> exchangeRate(Input input) throws Exception;
}
