package me.hjjang.dddstart.intrastructor;

import me.hjjang.dddstart.domain.Money;
import me.hjjang.dddstart.domain.OrderLine;

import java.util.List;

public class DroolsRuleDiscounter implements RuleDiscounter {

    private KieContainer kContainer;

    public DroolsRuleDiscounter() {
        KieServices ks = KieServices.Factory.get();
        this.kContainer = ks.getKieClasspathContainer();
    }

    @Override
    public Money applyRules(Customer customer, List<OrderLine> orderLines) {
        KieSession kSession = kContainer.newKieSession("discountSession");

        try {

            kSession.fireAllRules();
        } finally {
            kSession.dispose();
        }
        return money.toImmutableMoney();
    }
}
