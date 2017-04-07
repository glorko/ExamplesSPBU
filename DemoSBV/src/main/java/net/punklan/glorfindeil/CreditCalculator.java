package net.punklan.glorfindeil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;

/**
 * Created by st020794 on 07.04.2017.
 */
@Configuration
public class CreditCalculator {

    @Qualifier("creditHelperImplExternal")
    @Autowired
    private CreditHelper creditHelperExternal;

    @Qualifier("creditHelperInternal")
    @Autowired
    private CreditHelper creditHelperInternal;

    public Integer calculateAllCredits() {
        return creditHelperExternal.getCreditCount() + creditHelperInternal.getCreditCount();
    }
}
