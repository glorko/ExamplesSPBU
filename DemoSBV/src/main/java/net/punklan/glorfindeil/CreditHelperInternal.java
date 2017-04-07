package net.punklan.glorfindeil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * Created by st020794 on 07.04.2017.
 */
@Service
public class CreditHelperInternal implements CreditHelper {



    @Override
    public Integer getCreditCount() {
        return 8;
    }
}
