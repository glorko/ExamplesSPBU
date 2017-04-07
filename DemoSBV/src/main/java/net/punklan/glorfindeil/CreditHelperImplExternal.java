package net.punklan.glorfindeil;

import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * Created by st020794 on 07.04.2017.
 */
@Service
public class CreditHelperImplExternal implements CreditHelper {
    @Override
    public Integer getCreditCount() {
        return 66;
    }

    public void something(){
        System.out.println("WOW");
    }
}
