package io.cosmos.assign.assignrule;

import io.cosmos.assign.Customer;

public class AgeFilter implements Filterable {
    private int minAge;
    private int maxAge;

    public AgeFilter(int minAge, int maxAge) {
        this.minAge = minAge;
        this.maxAge = maxAge;
    }

    @Override
    public boolean isSatisfied(Customer customer) {
        if(this.minAge <= customer.getAge()
        && customer.getAge() <= this.maxAge) {
            return true;
        }

        return false;
    }
}
