package net.punklan.glorfindeil.cyrrencyexample;

import java.util.Map;

/**
 * Created by st020794 on 05.05.2017.
 */
public class ServiceAnswerDTO {
    Currency base;
    Map<Currency, Double> rates;

    public Currency getBase() {
        return base;
    }

    public void setBase(Currency base) {
        this.base = base;
    }

    public Map<Currency, Double> getRates() {
        return rates;
    }

    public void setRates(Map<Currency, Double> rates) {
        this.rates = rates;
    }



}
