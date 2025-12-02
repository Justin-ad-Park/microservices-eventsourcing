package io.cosmos.assign.comparator;

import io.cosmos.assign.Customer;

public class AgeAssignComparator implements AssignComparator {
    @Override
    public int compare(Customer before, Customer after) {
        return before.getAge() - after.getAge();
    }
}
