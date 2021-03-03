package me.hjjang.dddstart.intrastructor;

import java.util.List;

public class DroolsRuleEngine {
    private KieContainer kContainer;

    public DroolsRuleEngine() {
        KieServices ks = KieServices.Factory.get();
        this.kContainer = ks.getKieClasspathContainer();
    }

    public void evalute(String sessionName, List<?> facts) {
        KieSession kSession = kContainer.newKieSession(sessionName);
        try {
            facts.forEach(x -> kSession.insert(x));
            kSession.fireAllRules();
        } finally {
            kSession.dispose();
        }
    }
}
