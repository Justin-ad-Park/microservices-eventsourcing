package io.cosmos.assign;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class Birthday {
    private LocalDate birthday;


    public Birthday(String birthdayStr) {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
//        this.birthday = LocalDate.parse(birthdayStr, formatter);
    }

    public int getAge() {
        return 0;
//        LocalDate today = LocalDate.now();
//        return today.getYear() - birthday.getYear();
    }
}
