package com.example.exchangerate.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Input {
  private Double amount;
  private String originCurrency;
  private String destinyCurrency;

}
