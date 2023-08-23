package com.example.exchangerate.service.imp;

import com.example.exchangerate.enums.ExchangeRateEnum;
import com.example.exchangerate.handler.ErrorEnum;
import com.example.exchangerate.models.Input;
import com.example.exchangerate.models.Output;
import com.example.exchangerate.service.ExchangeRateService;
import com.example.exchangerate.utils.Constant;
import java.util.Optional;
import org.apache.commons.math3.util.Precision;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ExchangeRateServiceImp implements ExchangeRateService {

  @Override
  public Mono<Output> exchangeRate(Input input) throws Exception {
    Double tipoCambio;
    Output output = new Output();
    output.setAmount(input.getAmount());
    output.setMonedaOrigen(input.getOriginCurrency());
    output.setMonedaDestino(input.getDestinyCurrency());
    tipoCambio = getExchangeRate(input);
    output.setTipoCambio(tipoCambio);
    output.setAmountTipoCambio(getAmountTipoCambio(input.getAmount(), tipoCambio));
    return Mono.just(output);
  }

  private double getAmountTipoCambio(Double amount, Double tipoCambio){
    return Precision.round(amount*tipoCambio, Constant.ROUND_DECIMAL);
  }

  private double getExchangeRate(Input input) throws Exception {
    Optional<Double> exchangeRateTemp;
    exchangeRateTemp = ExchangeRateEnum.getTipoCambioCompra(input.getOriginCurrency(),
        input.getDestinyCurrency());
    if(exchangeRateTemp.isEmpty()){
      exchangeRateTemp = ExchangeRateEnum.getTipoCambioVenta(input.getDestinyCurrency(),
          input.getOriginCurrency());
    }
    if(exchangeRateTemp.isEmpty()){
      throw new Exception(ErrorEnum.ERROR_500.code);
      //throw new Exception("No se encontró tipo de cambio para las monedas específicas");
    }
    return Precision.round(exchangeRateTemp.get(), Constant.ROUND_DECIMAL);
  }
}
