package com.example.exchangerate.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Output {
  private Double amount;
  private Double amountTipoCambio;
  private String monedaOrigen;
  private String monedaDestino;
  private Double tipoCambio;

}
