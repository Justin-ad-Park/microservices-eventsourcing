package io.cosmos.assign;

import java.util.*;

public class AssignService {

    /*
        1. 30세 이상인 고객을 추출하고,
        2. 나이를 오름차순으로 정렬한 후,
        3. 설문 조사원에게 순차적으로 배정(분배)한다.

     */
    public List<Customer> assign(List<Customer> customers, List<Surveyor> surveyors) {
        List<Customer> filteredCustomer = new ArrayList<>();

        // 1. 30세 이상 고객 추출
        for (Customer customer: customers) {
            if (this.calculateAge(customer) > 30) {
                filteredCustomer.add(customer);
            }
        }

        // 2. 나이를 오름차순으로 정렬
        filteredCustomer.sort(new Comparator<Customer>() {
            @Override
            public int compare(Customer customer1, Customer customer2) {
                return calculateAge(customer1).compareTo(calculateAge(customer2));
            }
        });

        // 3. 설문 조사원을 순차적으로 배정
        int i = 0;
        for (Customer customer: filteredCustomer) {
            Surveyor surveyor = surveyors.get(i % surveyors.size());
            customer.setSurveyorId(surveyor.getId());
            i++;
        }

        return filteredCustomer;
    }

    /*
        나이 계산 로직 - 연도만 사용해서 단순하게 나이 계산
     */
    public Integer calculateAge(Customer customer) {
        String year = customer.getBirthday().substring(0, 4);
        String month = customer.getBirthday().substring(5, 6);
        String day = customer.getBirthday().substring(7, 8);

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, Integer.valueOf(year));
        calendar.set(Calendar.MONTH, Integer.valueOf(month)-1);
        calendar.set(Calendar.DAY_OF_MONTH, Integer.valueOf(day));

        Date birthDate = calendar.getTime();

        Calendar birthdayCalendar = Calendar.getInstance();
        birthdayCalendar.setTime(birthDate);
        Calendar todayCalendar = Calendar.getInstance();

        return todayCalendar.get(Calendar.YEAR) - birthdayCalendar.get(Calendar.YEAR);
    }
}
