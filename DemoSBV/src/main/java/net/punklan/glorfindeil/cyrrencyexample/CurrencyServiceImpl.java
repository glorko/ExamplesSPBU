package net.punklan.glorfindeil.cyrrencyexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by st020794 on 05.05.2017.
 */
@Service
public class CurrencyServiceImpl implements CurrencyService {

    private static final String API_URL = "http://api.fixer.io/latest?base={base}&symbols={symbols}";

    @Autowired
    RestTemplate template;

    @Override
    public Double getRate(Currency base, Currency to) {
        ServiceAnswerDTO answer = template.getForObject(API_URL, ServiceAnswerDTO.class, base, to);
        return answer.getRates().get(to);
    }
}
