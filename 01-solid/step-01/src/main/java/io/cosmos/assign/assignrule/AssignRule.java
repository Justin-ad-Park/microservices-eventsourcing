package io.cosmos.assign.assignrule;

import io.cosmos.assign.Customer;

public interface AssignRule {
    public boolean isSatisfied(Customer customer);
}
