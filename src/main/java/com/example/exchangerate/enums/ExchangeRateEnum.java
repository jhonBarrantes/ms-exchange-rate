package com.example.exchangerate.enums;

import java.util.Arrays;
import java.util.Optional;

public enum ExchangeRateEnum {
  SOL_TO_DOLAR("PEN", "USD", 3.724, 3.729),
  SOL_TO_LIBRA("PEN", "GBP", 4.745,5.152),
  SOL_TO_YEN("PEN", "JPY", 0.026, 0.028),
  SOL_TO_MEX("PEN", "MXN", 0.220,0.256),
  SOL_TO_FRANCO("PEN", "CHF", 3.942, 4.713),
  SOL_TO_EURO("PEN", "EUR", 3.891,4.255);

  public String originCurrency;
  public String destinyCurrency;
  public Double valorCompra;
  public Double valorVenta;

  private ExchangeRateEnum(String originCurrency, String destinyCurrency, Double valorCompra, Double valorVenta){
    this.originCurrency = originCurrency;
    this.destinyCurrency = destinyCurrency;
    this.valorCompra = valorCompra;
    this.valorVenta = valorVenta;
  }

  //usado para monedas extranjeras
  public static Optional<Double> getTipoCambioVenta(String originCurrency, String destinyCurrency){
    Optional<ExchangeRateEnum> tipoCambio;
        tipoCambio =  Arrays.stream(values())
                            .filter( m -> m.originCurrency.equalsIgnoreCase(originCurrency))
            .filter(m -> m.destinyCurrency.equalsIgnoreCase(destinyCurrency))
            .findFirst();
        if(tipoCambio.isPresent()){
          return Optional.of(tipoCambio.get().valorCompra);
        }else{
          return Optional.empty();
        }
  }

  //usado para comprar moneda local
  public static Optional<Double> getTipoCambioCompra(String originCurrency, String destinyCurrency){
    Optional<ExchangeRateEnum> tipoCambio;
    tipoCambio =  Arrays.stream(values())
        .filter( m -> m.originCurrency.equalsIgnoreCase(originCurrency))
        .filter(m -> destinyCurrency.equalsIgnoreCase(destinyCurrency))
        .findFirst();
    if(tipoCambio.isPresent()){
      return Optional.of(1/tipoCambio.get().valorCompra);
    }else{
      return Optional.empty();
    }
  }

  private void validateIfIsZero(Double value){
    if(value==0){
      //throws new Exception(());
    }
  }

}
