package io.cosmos.assign.assignrule;

import io.cosmos.assign.customer.Customer;

public interface Filterable {
    boolean isSatisfied(Customer customer);
}
