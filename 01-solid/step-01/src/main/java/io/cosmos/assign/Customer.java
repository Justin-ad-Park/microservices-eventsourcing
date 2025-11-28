package io.cosmos.assign;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Customer {

    private String id;
    private String name;

    private Birthday birthday;

    /**
     *  연락처를 값 객체로 분리한다.
     *  1. 유선전화(LandLine, MobilePhone은 Enum으로 구분)
     */
    private String landlinePhone;
    private String mobilePhone;
    private String gender;

    private String surveyorId;

    public Customer(String id, String name, String birthday, String gender) {
        this.id = id;
        this.name = name;
        this.birthday = new Birthday(birthday);
        this.gender = gender;
    }

    public int getAge() {
        return this.getBirthday().getAge();
    }
}
