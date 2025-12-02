package io.cosmos.assign.assignrule;

import io.cosmos.assign.Customer;

import java.util.ArrayList;
import java.util.List;

public interface Filterable {
    boolean isSatisfied(Customer customer);

    default List<Customer> filter(List<Customer> customers) {
        List<Customer> results = new ArrayList<>();

        for(Customer customer : customers) {
            if(this.isSatisfied(customer)) results.add(customer);
        }

        return results;
    }

}
