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

    public Customer(String id, String name, String birthday, String gender, String landlinePhone, String mobilePhone) {
        this.id = id;
        this.name = name;
        this.birthday = new Birthday(birthday);
        this.landlinePhone = new Contact(Contact.ContactType.Landline, landlinePhone);
        this.mobilePhone = new Contact(Contact.ContactType.Landline,mobilePhone);
        this.gender = gender;
    }

    /**
     *  연락처를 값 객체로 분리한다.
     *  1. 유선전화(LandLine, MobilePhone은 Enum으로 구분)
     */
    private Contact landlinePhone;
    private Contact mobilePhone;
    private String gender;

    public Integer getAge() {
        return this.getBirthday().getAge();
    }
}
