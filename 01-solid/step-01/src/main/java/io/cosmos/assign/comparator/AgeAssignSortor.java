package io.cosmos.assign.comparator;

import io.cosmos.assign.Customer;

public class AgeAssignSortor implements AssignSortable {
    @Override
    public int compare(Customer before, Customer after) {
        return before.getAge() - after.getAge();
    }
}
