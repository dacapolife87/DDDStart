package me.hjjang.dddstart.service;

import me.hjjang.dddstart.domain.Money;
import me.hjjang.dddstart.domain.OrderLine;
import me.hjjang.dddstart.intrastructor.DroolsRuleEngine;
import me.hjjang.dddstart.intrastructor.RuleDiscounter;

import java.util.Arrays;
import java.util.List;

public class CalculateDiscountService {
    private CustomerRepository customerRepository;
    private RuleDiscounter ruleDiscounter;

    public CalculateDiscountService(CustomerRepository customerRepository, RuleDiscounter ruleDiscounter) {
        this.customerRepository = customerRepository;
        this.ruleDiscounter = ruleDiscounter;
    }

    public Money calculateDiscount(List<OrderLine> orderLines, String customId) {
        Customer customer = findCustomer(customId);
        return ruleDiscounter.applyRules(customer, orderLines);
    }

    private Customer findCustomer(String customId) {
        Customer customer = customerRepository.findById(customId);
        if(customer == null) {
            throw new NoCustomerException();
        }
        return customer;
    }
}
