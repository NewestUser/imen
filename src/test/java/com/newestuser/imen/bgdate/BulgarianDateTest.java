package com.newestuser.imen.bgdate;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class BulgarianDateTest {

    @Test
    public void formatGregorianDatetoBulgarianDate() {
        Date gregorianDate = firstOfJanuary(2019);

        BulgarianDate bulgarianDate = new BulgarianDate(gregorianDate);
        String formatedDate = bulgarianDate.format(bulgarianDate);
        assertEquals(formatedDate, "10 Алем, 6787 Докс");
    }

    private Date firstOfJanuary(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, Calendar.JANUARY);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }

    @Test
    public void checkLeapYear() {
        Date gregorianDate = secondOfJanuary(2020);
        BulgarianDate bulgarianDate = new BulgarianDate(gregorianDate);
        String formatedDate = bulgarianDate.format(bulgarianDate);
        assertEquals(formatedDate, "11 Алем, 6788 Сомор");
    }

    private Date secondOfJanuary(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, Calendar.JANUARY);
        calendar.set(Calendar.DAY_OF_MONTH, 2);
        return calendar.getTime();
    }

    @Test
    public void checkLeapYearSecondTest() {
        Date gregorianDate = thirdOfMarch(1800);
        BulgarianDate bulgarianDate = new BulgarianDate(gregorianDate);
        String formatedDate = bulgarianDate.format(bulgarianDate);
        assertEquals(formatedDate, "10 Читем, 6568 Бечин");
    }

    private Date thirdOfMarch(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, Calendar.MARCH);
        calendar.set(Calendar.DAY_OF_MONTH, 3);
        return calendar.getTime();
    }
}