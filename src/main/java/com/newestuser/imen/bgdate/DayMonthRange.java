package com.newestuser.imen.bgdate;

/**
 * This class is responsible for determining the name of the month based on the gregorian day.
 * Depending on which gregorian day the bulgarian month might vary.
 * Example: from 22of December up until 22nd of January it is the bulgarian month 'Алем'.
 */
class DayMonthRange {
    private final int startDay;
    private final int endDay;
    private final String monthInRange;
    private final String monthOutOfRange;

    DayMonthRange(int startDay, int endDay, String monthInRange, String monthOutOfRange) {
        this.startDay = startDay;
        this.endDay = endDay;
        this.monthInRange = monthInRange;
        this.monthOutOfRange = monthOutOfRange;
    }

    /**
     * Checks if the day is in the configured range. The matching is inclusive.
     *
     * @param dayOfMonth the day in a given gregorian month.
     * @return the formatted Bulgarian month.
     */
    String getBulgarianMonth(int dayOfMonth) {
        if (startDay <= dayOfMonth && endDay >= dayOfMonth) {
            return monthInRange;
        }
        return monthOutOfRange;
    }

    /**
     * Checks if the day is in the first part of Gregorian month or in the second. The matching is inclusive.
     *
     * @param currentDayOfMonth the day in the gregorian month.
     * @return true if the given day is in the first part of the gregorian month.
     */
    boolean findIsInFirstMonthPart(int currentDayOfMonth) {
        if (startDay <= currentDayOfMonth && endDay >= currentDayOfMonth) {
            return true;
        }
        return false;
    }
}
