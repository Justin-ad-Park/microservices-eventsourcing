package io.cosmos.assign.comparator;

import io.cosmos.assign.Customer;

import java.util.Comparator;
import java.util.List;

public interface AssignSortable extends Comparator<Customer> {

    default List<Customer> sort(List<Customer> customers) {
        customers.sort(this);
        return customers;
    }
}
