package com.newestuser.imen.bgdate;

import java.time.Year;
import java.util.Calendar;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * This class is responsible for calculating Bulgarian date.
 * Depending on a given Gregorian date.
 * Example: 1st of January 2019 is 10 Алем, 6787 Докс
 */
public class BulgarianDate {
    private final int bulgarianDateDay;
    private final String bulgarianDateMonth;
    private final int bulgarianDateYear;
    private final String bulgarianDateTypeOfYear;

    /**
     * Instantiate BulgarianDate object.
     * Depending on the given Gregorian date.
     *@param gregorianDate given Gregorian date
     */
    public BulgarianDate(Date gregorianDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(gregorianDate);
        this.bulgarianDateDay = findBulgarianDay(calendar.get(Calendar.DAY_OF_MONTH),
                convertMonth(calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH)),
                calendar.get(Calendar.MONTH) + 1);
        this.bulgarianDateMonth = convertMonth(calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH));
        this.bulgarianDateYear = calendar.get(Calendar.YEAR) + 4768;
        this.bulgarianDateTypeOfYear = findYearType(this.bulgarianDateYear);
    }

    public BulgarianDate() {
        this(new Date());
    }

    private static final Map<Integer, DayMonthRange> GREGORIAN_MONTH_TO_BG_MONTH = new HashMap<>() {
        {
            put(1, new DayMonthRange(1, 22, "Алем", "Тутом"));
            put(2, new DayMonthRange(1, 21, "Тутом", "Читем"));
            put(3, new DayMonthRange(1, 22, "Читем", "Твирем"));
            put(4, new DayMonthRange(1, 22, "Твирем", "Вечем"));
            put(5, new DayMonthRange(1, 22, "Вечем", "Шехтем"));
            put(6, new DayMonthRange(1, 21, "Шехтем", "Сетем"));
            put(7, new DayMonthRange(1, 22, "Сетем", "Бехти"));
            put(8, new DayMonthRange(1, 22, "Бехти", "Нунтем"));
            put(9, new DayMonthRange(1, 20, "Нунтем", "Елем"));
            put(10, new DayMonthRange(1, 21, "Елем", "Ениалем"));
            put(11, new DayMonthRange(1, 20, "Ениалем", "Алтом"));
            put(12, new DayMonthRange(1, 20, "Алтом", "Алем"));
        }
    };

    private static Map<Integer, String> YEAR_TYPES = new HashMap<>() {
        {
            put(0, "Верени");
            put(1, "Дилом");
            put(2, "Имен");
            put(3, "Теку");
            put(4, "Бечин");
            put(5, "Тох");
            put(6, "Етх");
            put(7, "Докс");
            put(8, "Сомор");
            put(9, "Шегор");
            put(10, "Барс");
            put(11, "Дван");
        }
    };

    private static Map<String, Integer[]> DAY_CONVERSION_VALUES = new HashMap<>() {
        {
            put("Алем", new Integer[]{9, 22});
            put("Тутом", new Integer[]{9, 21});
            put("Читем", new Integer[]{8, 22});
            put("Твирем", new Integer[]{9, 22});
            put("Вечем", new Integer[]{8, 22});
            put("Шехтем", new Integer[]{9, 21});
            put("Сетем", new Integer[]{9, 22});
            put("Бехти", new Integer[]{9, 21});
            put("Нунтем", new Integer[]{8, 20});
            put("Елем", new Integer[]{10, 21});
            put("Ениалем", new Integer[]{10, 20});
            put("Алтом", new Integer[]{10, 21});
        }
    };

    /**
     * Converts the passed gregorian day of the month to the day according to the Bulgarian calendar.
     *
     * @param currentDay current day in a given gregorian month.
     * @param bgMonth    current month according to the Bulgarian calendar.
     * @param month      current month according to the Gregorian calendar.
     * @return the converted Bulgarian day.
     */
    private static int findBulgarianDay(int currentDay, String bgMonth, int month) {
        DayMonthRange dayMonthRange = GREGORIAN_MONTH_TO_BG_MONTH.get(month);
        bgMonth = dayMonthRange.getBulgarianMonth(currentDay);
        int bulgarianDateDay = currentDay;
        if (DAY_CONVERSION_VALUES.containsKey(bgMonth)) {
            if (dayMonthRange.findIsInFirstMonthPart(currentDay)) {
                bulgarianDateDay += DAY_CONVERSION_VALUES.get(bgMonth)[0];
            } else {
                bulgarianDateDay -= DAY_CONVERSION_VALUES.get(bgMonth)[1];
            }
        }
        if (month > 2 && !findIsLeapYear(Year.now().getValue())) {
            bulgarianDateDay -= 1;
        }
        return bulgarianDateDay;
    }

    /**
     * Converts the passed gregorian month to the month according to the Bulgarian calendar.
     *
     * @param month      current month according to the Gregorian calendar.
     * @param currentDay current day in a given gregorian month.
     * @return the converted Bulgarian month.
     */
    private String convertMonth(int month, int currentDay) {
        if (month == 12 && currentDay == 21) {
            return "Нова година";
        }
        DayMonthRange dayMonthRange = GREGORIAN_MONTH_TO_BG_MONTH.get(month);
        return dayMonthRange.getBulgarianMonth(currentDay);
    }


    /**
     * Determines the passed Bulgarian year into Bulgarian year type.
     *
     * @param bulgarianDateYear current year according to the Bulgarian calendar.
     * @return Bulgarian type of year.
     */
    private String findYearType(int bulgarianDateYear) {
        return YEAR_TYPES.get(bulgarianDateYear % 12);
    }

    /**
     * Determines the passed Gregorian year is leap.
     *
     * @param currentYear current year according to the Gregorian calendar.
     * @return true if the passed year is leap.
     */
    private static boolean findIsLeapYear(int currentYear) {
        return currentYear % 4 == 0 && currentYear % 100 != 0 || currentYear % 400 == 0;
    }

    /**
     * Creates current Bulgarian date.
     * Bulgarian year is calculated as follows: current year + 4768.
     *
     * @return BulgarianDate object with the current date.
     */
    public BulgarianDate now() {
        return new BulgarianDate();
    }

    /**
     * Provides appropriate format for the passed BulgarianDate object.
     *
     * @param bulgarianDate converted Bulgarian date
     * @return the formatted Bulgarian month.
     */
    public String format(BulgarianDate bulgarianDate) {
        return bulgarianDate.bulgarianDateDay
                + " "
                + bulgarianDate.bulgarianDateMonth
                + ", "
                + bulgarianDate.bulgarianDateYear
                + " "
                + bulgarianDate.bulgarianDateTypeOfYear;
    }
}
