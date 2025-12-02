package io.cosmos.assign;

import io.cosmos.assign.assignrule.Filterable;
import io.cosmos.assign.comparator.AssignComparator;
import io.cosmos.assign.distribute.Distributable;

import java.util.*;

public class AssignService {
    private final Filterable assignRule;
    private final AssignComparator comparator;
    private final Distributable distributable;

    public AssignService(Filterable assignRule, AssignComparator comparator, Distributable distributable) {
        this.assignRule = assignRule;
        this.comparator = comparator;
        this.distributable = distributable;
    }


    /*
        1. 30세 이상인 고객을 추출하고,
        2. 나이를 오름차순으로 정렬한 후,
        3. 설문 조사원에게 순차적으로 배정(분배)한다.

     */
    public List<Assign> assign(List<Customer> customers, List<Surveyor> surveyors) {
        List<Customer> filteredCustomer = assignRule.filter(customers);

        // 2. 나이를 오름차순으로 정렬
        filteredCustomer.sort(this.comparator);

        // 3. 설문 조사원을 순차적으로 배정
        return distributable.distribute(filteredCustomer, surveyors);
    }
}
