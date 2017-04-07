package net.punklan.glorfindeil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * Created by st020794 on 07.04.2017.
 */

@RestController
public class CreditController {

    @Autowired
    CreditCalculator calc;

    @RequestMapping("/count")
    public Integer getCount() {
        return calc.calculateAllCredits();
    }

    ;
    @RequestMapping("/credit")
    public Credit returnCredit() {
        return new Credit(new Random().nextInt(), "sfgdf");
    }

    ;

}
