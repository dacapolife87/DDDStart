package me.hjjang.dddstart.intrastructor;

import me.hjjang.dddstart.domain.Money;
import me.hjjang.dddstart.domain.OrderLine;

import java.util.List;

public interface RuleDiscounter {
    public Money applyRules(Customer customer, List<OrderLine> orderLines);
}
