package io.cosmos.assign;

import java.util.*;

public class AssignService {

    /*
        1. 30세 이상인 고객을 추출하고,
        2. 나이를 오름차순으로 정렬한 후,
        3. 설문 조사원에게 순차적으로 배정(분배)한다.

     */
    public List<Assign> assign(List<Customer> customers, List<Surveyor> surveyors) {
        List<Customer> filteredCustomer = new ArrayList<>();

        // 1. 30세 이상 고객 추출
        for (Customer customer: customers) {
            if (customer.getAge() > 30) {
                filteredCustomer.add(customer);
            }
        }

        // 2. 나이를 오름차순으로 정렬
        filteredCustomer.sort(new Comparator<Customer>() {
            @Override
            public int compare(Customer customer1, Customer customer2) {
                return Integer.compare(customer1.getAge(), customer2.getAge());
            }
        });

        // 3. 설문 조사원을 순차적으로 배정
        int i = 0;
        List<Assign> assigns = new ArrayList<>();
        for (Customer customer: filteredCustomer) {
            Surveyor surveyor = surveyors.get(i % surveyors.size());
            Assign newAssign = new Assign(customer, surveyor);
            assigns.add(newAssign);
            i++;
        }

        return assigns;
    }
}
