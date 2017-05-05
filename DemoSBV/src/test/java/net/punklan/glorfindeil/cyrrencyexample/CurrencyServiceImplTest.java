package net.punklan.glorfindeil.cyrrencyexample;

import net.punklan.glorfindeil.DemoSbvApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by st020794 on 05.05.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoSbvApplication.class)
public class CurrencyServiceImplTest {

    @Autowired
    CurrencyService service;

    @Test
    public void getRate() throws Exception {
        Double rate = service.getRate(Currency.RUB, Currency.USD);
        System.out.println("rate = " + rate);
        assertNotNull(rate);

    }

}