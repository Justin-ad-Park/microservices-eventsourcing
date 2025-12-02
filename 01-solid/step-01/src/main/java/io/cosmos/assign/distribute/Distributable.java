package io.cosmos.assign.distribute;

import io.cosmos.assign.Assign;
import io.cosmos.assign.Customer;
import io.cosmos.assign.Surveyor;

import java.util.List;

public interface Distributable {
    public List<Assign> distribute(List<Customer>  customers, List<Surveyor>  surveyors);
}
