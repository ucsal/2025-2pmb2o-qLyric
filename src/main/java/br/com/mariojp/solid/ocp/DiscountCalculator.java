package br.com.mariojp.solid.ocp;

import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;

public class DiscountCalculator {

    private final Map<CustomerType, DiscountPolicy> policies;

    public DiscountCalculator(Map<CustomerType, DiscountPolicy> policies) {
        Objects.requireNonNull(policies, "policies não pode ser null");
        // Usa EnumMap para eficiência e type-safety do enum.
        this.policies = new EnumMap<>(CustomerType.class);
        this.policies.putAll(policies);
    }

    public DiscountCalculator() {
        this(defaultPolicies());
    }

    private static Map<CustomerType, DiscountPolicy> defaultPolicies() {
        Map<CustomerType, DiscountPolicy> map = new EnumMap<>(CustomerType.class);
        map.put(CustomerType.REGULAR, new RegularPolicy()); // 5%
        map.put(CustomerType.PREMIUM, new PremiumPolicy()); // 10%
        map.put(CustomerType.PARTNER, new PartnerPolicy()); // 12% (100 -> 88)
        return map;
    }

    public double apply(double amount, CustomerType type) {
        DiscountPolicy policy = policies.get(type);
        return (policy == null) ? amount : policy.apply(amount);
    }
}
