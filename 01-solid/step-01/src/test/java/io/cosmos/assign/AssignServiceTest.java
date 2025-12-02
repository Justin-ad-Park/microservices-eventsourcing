package io.cosmos.assign;

import io.cosmos.assign.assignrule.AgeFilter;
import io.cosmos.assign.assignrule.Filterable;
import io.cosmos.assign.comparator.AgeAssignSortor;
import io.cosmos.assign.comparator.AssignSortable;
import io.cosmos.assign.distribute.Distributable;
import io.cosmos.assign.distribute.RoundRobinDistributor;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AssignServiceTest {

    @Test
    public void assign() {

        Filterable assignRule = new AgeFilter(30, 100);
        AssignSortable comparator = new AgeAssignSortor();
        Distributable distributable = new RoundRobinDistributor();

        AssignService assignService = new AssignService(assignRule, comparator, distributable);

        List<Customer> customers = getCustomers();
        List<Surveyor> surveyors = getSurveyors();

        printCustomers(customers);

        List<Assign> filteredAssign = assignService.assign(customers, surveyors);

        printFilteredAssign(filteredAssign);

        assertEquals("S2", filteredAssign.get(1).getSurveyor().getId());
    }

    private static void printCustomers(List<Customer> customers) {
        for (Customer customer: customers) {
            System.out.println(customer.getName() + "(" + customer.getAge() + ")");
        }
        System.out.println("");
    }

    private static void printFilteredAssign(List<Assign> filteredAssign) {
        for (Assign assign: filteredAssign) {
            System.out.println(assign.getCustomer().getName() + "(" + assign.getCustomer().getAge() + "): " + assign.getSurveyor().getId());
        }
    }

    private static List<Surveyor> getSurveyors() {
        Surveyor surveyor1 = new Surveyor("S1", "조사원#1");
        Surveyor surveyor2 = new Surveyor("S2", "조사원#2");

        List<Surveyor> surveyors = new ArrayList<>();
        surveyors.add(surveyor1);
        surveyors.add(surveyor2);
        return surveyors;
    }

    private static List<Customer> getCustomers() {
        Customer customer1 = new Customer("C1", "고객#1", "19911001", "W", "","");
        Customer customer2 = new Customer("C2", "고객#2", "19901001", "M", "","");
        Customer customer3 = new Customer("C3", "고객#3", "19891001", "M", "","");
        Customer customer4 = new Customer("C4", "고객#4", "19971001", "W", "","");
        Customer customer5 = new Customer("C5", "고객#5", "19921001", "M", "","");

        List<Customer> customers = new ArrayList<>();
        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
        customers.add(customer4);
        customers.add(customer5);
        return customers;
    }

}
