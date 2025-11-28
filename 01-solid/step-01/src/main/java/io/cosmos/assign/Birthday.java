package io.cosmos.assign;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Birthday {
    private LocalDate birthday;


    public Birthday(String birthdayStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        this.birthday = LocalDate.parse(birthdayStr, formatter);
    }

    public int getAge() {
        LocalDate today = LocalDate.now();
        return today.getYear() - birthday.getYear();
    }
}
