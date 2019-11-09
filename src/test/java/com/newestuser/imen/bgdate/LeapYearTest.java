package com.newestuser.imen.bgdate;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LeapYearTest {

    @Test
    public void findIsLeapYear() {
        assertFalse(findIsLeapYear(1800));
        assertTrue(findIsLeapYear(2020));
    }

    private static boolean findIsLeapYear(int currentYear) {
        if (currentYear % 4 == 0 && currentYear % 100 != 0) {
            return true;
        }
        if (currentYear % 100 == 0 && currentYear % 400 == 0) {
            return true;
        }
        return false;
    }

}