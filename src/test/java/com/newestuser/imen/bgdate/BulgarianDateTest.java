package com.newestuser.imen.bgdate;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class BulgarianDateTest {

    @Test
    public void formatGregorianDatetoBulgarianDate() {
        Date gregorianDate = newDate(1, Calendar.JANUARY, 2019);
        BulgarianDate bulgarianDate = new BulgarianDate(gregorianDate);
        String formatedDate = bulgarianDate.format(bulgarianDate);
        assertEquals(formatedDate, "10 Алем, 6787 Докс");
    }

    @Test
    public void checkLeapYear() {
        Date gregorianDate = newDate(2, Calendar.JANUARY, 2020);
        BulgarianDate bulgarianDate = new BulgarianDate(gregorianDate);
        String formatedDate = bulgarianDate.format(bulgarianDate);
        assertEquals(formatedDate, "11 Алем, 6788 Сомор");
    }

    @Test
    public void checkNonCenturialLeapYear() {
        Date gregorianDate = newDate(3, Calendar.MARCH, 1800);
        BulgarianDate bulgarianDate = new BulgarianDate(gregorianDate);
        String formatedDate = bulgarianDate.format(bulgarianDate);
        assertEquals(formatedDate, "10 Читем, 6568 Бечин");
    }

    private Date newDate(int day, int month, int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        return calendar.getTime();
    }
}