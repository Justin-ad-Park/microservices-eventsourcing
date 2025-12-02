package io.cosmos.assign.assignrule;

import io.cosmos.assign.Customer;

public interface FilterRule {
    public boolean isSatisfied(Customer customer);
}
