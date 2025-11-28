package io.cosmos.assign;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class BirthdayTest {

    @Test
    void getAge() {
        Birthday birthday = new Birthday("20001001");
        int actual = birthday.getAge();

        LocalDate today = LocalDate.now();
        int expect = today.getYear() - 2000;    //연도가 바뀌어도 늘 테스트 결과가 맞도록

        Assertions.assertEquals(expect, actual);
    }
}
