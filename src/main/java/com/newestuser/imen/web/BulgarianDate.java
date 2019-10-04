package com.newestuser.imen.web;

import java.time.Year;

import java.util.Calendar;


public class BulgarianDate {
    private int bulgarianDateDay;
    private String bulgarianDateMonth;
    private int bulgarianDateYear;
    private String bulgarianDateTypeOfYear;
    private boolean isLeapYear;

    private BulgarianDate() {
        this.bulgarianDateDay = findDayofMonth(Calendar.getInstance().get(Calendar.MONTH) + 1, Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        this.bulgarianDateMonth = convertMonth(Calendar.getInstance().get(Calendar.MONTH) + 1, Calendar.getInstance().get(Calendar.DAY_OF_MONTH)); //+1 added because months are 0-indexed
        this.bulgarianDateYear = Year.now().getValue() + 4768;
        this.bulgarianDateTypeOfYear = findYearType(this.bulgarianDateYear);
    }

    private static String convertMonth(int month, int currentDay) {
        String bulgarianMonth = "";
        switch (month) {
            case 1:
                if (currentDay >= 1 && currentDay <= 22) {
                    bulgarianMonth = "Алем";
                } else {
                    bulgarianMonth = "Тутом";
                }
                break;
            case 2:
                if (currentDay >= 1 && currentDay <= 21) {
                    bulgarianMonth = "Тутом";
                } else {
                    bulgarianMonth = "Читем";
                }
                break;
            case 3:
                if (currentDay >= 1 && currentDay <= 22) {
                    bulgarianMonth = "Читем";
                } else {
                    bulgarianMonth = "Твирем";
                }
                break;
            case 4:
                if (currentDay >= 1 && currentDay <= 22) {
                    bulgarianMonth = "Твирем";
                } else {
                    bulgarianMonth = "Вечем";
                }
                break;
            case 5:
                if (currentDay >= 1 && currentDay <= 22) {
                    bulgarianMonth = "Вечем";
                } else {
                    bulgarianMonth = "Шехтем";
                }
                break;
            case 6:
                if (currentDay >= 1 && currentDay <= 21) {
                    bulgarianMonth = "Шехтем";
                } else {
                    bulgarianMonth = "Сетем";
                }
                break;
            case 7:
                if (currentDay >= 1 && currentDay <= 22) {
                    bulgarianMonth = "Сетем";
                } else {
                    bulgarianMonth = "Бехти";
                }
                break;
            case 8:
                if (currentDay >= 1 && currentDay <= 21) {
                    bulgarianMonth = "Бехти";
                } else {
                    bulgarianMonth = "Нунтем";
                }
                break;
            case 9:
                if (currentDay >= 1 && currentDay <= 20) {
                    bulgarianMonth = "Нунтем";
                } else {
                    bulgarianMonth = "Елем";
                }
                break;
            case 10:
                if (currentDay >= 1 && currentDay <= 21) {
                    bulgarianMonth = "Елем";
                } else {
                    bulgarianMonth = "Ениалем";
                }
                break;
            case 11:
                if (currentDay >= 1 && currentDay <= 20) {
                    bulgarianMonth = "Ениалем";
                } else {
                    bulgarianMonth = "Алтом";
                }
                break;
            case 12:
                if (currentDay >= 1 && currentDay <= 20) {
                    bulgarianMonth = "Алтом";
                } else if (currentDay == 21) {
                    bulgarianMonth = "Нова година";
                } else {
                    bulgarianMonth = "Алем";
                }
                break;
        }
        return bulgarianMonth;
    }

    private static int findDayofMonth(int currentMonth, int currentDay) {
        int bulgarianDayOfMonth = 0;
        switch (currentMonth) {
            case 1:
                if (currentDay >= 1 && currentDay <= 22) {
                    bulgarianDayOfMonth = currentDay + 9;
                } else {
                    bulgarianDayOfMonth = currentDay - 22;
                }
                break;
            case 2:
                if (currentDay >= 1 && currentDay <= 21) {
                    bulgarianDayOfMonth = currentDay + 9;
                } else if (currentDay > 21 && currentDay <= 28) {
                    bulgarianDayOfMonth = currentDay - 21;
                } else if (findIsLeapYear(Year.now().getValue()) && currentDay == 29) {
                    bulgarianDayOfMonth = 8;
                }
                break;
            case 3:
                if (currentDay >= 1 && currentDay <= 22) {
                    bulgarianDayOfMonth = currentDay + 8;
                } else {
                    bulgarianDayOfMonth = currentDay - 22;
                }
                if (!findIsLeapYear(Year.now().getValue())) {
                    bulgarianDayOfMonth -= 1;
                }
                break;
            case 4:
                if (currentDay >= 1 && currentDay <= 22) {
                    bulgarianDayOfMonth = currentDay + 9;
                } else {
                    bulgarianDayOfMonth = currentDay - 22;
                }
                if (!findIsLeapYear(Year.now().getValue())) {
                    bulgarianDayOfMonth -= 1;
                }
                break;
            case 5:
                if (currentDay >= 1 && currentDay <= 22) {
                    bulgarianDayOfMonth = currentDay + 8;
                } else {
                    bulgarianDayOfMonth = currentDay - 22;
                }
                if (!findIsLeapYear(Year.now().getValue())) {
                    bulgarianDayOfMonth -= 1;
                }
                break;

            case 6:
                if (currentDay >= 1 && currentDay <= 21) {
                    bulgarianDayOfMonth = currentDay + 9;
                } else {
                    bulgarianDayOfMonth = currentDay - 21;
                }
                if (!findIsLeapYear(Year.now().getValue())) {
                    bulgarianDayOfMonth -= 1;
                }
                break;
            case 7:
                if (currentDay >= 1 && currentDay <= 22) {
                    bulgarianDayOfMonth = currentDay + 9;
                } else {
                    bulgarianDayOfMonth = currentDay - 22;
                }
                if (!findIsLeapYear(Year.now().getValue())) {
                    bulgarianDayOfMonth -= 1;
                }
                break;
            case 8:
                if (currentDay >= 1 && currentDay <= 21) {
                    bulgarianDayOfMonth = currentDay + 9;
                } else {
                    bulgarianDayOfMonth = currentDay - 21;
                }
                if (!findIsLeapYear(Year.now().getValue())) {
                    bulgarianDayOfMonth -= 1;
                }
                break;
            case 9:
                if (currentDay >= 1 && currentDay <= 20) {
                    bulgarianDayOfMonth = currentDay + 8;
                } else {
                    bulgarianDayOfMonth = currentDay - 20;
                }
                if (!findIsLeapYear(Year.now().getValue())) {
                    bulgarianDayOfMonth -= 1;
                }
                break;
            case 10:
                if (currentDay >= 1 && currentDay <= 21) {
                    bulgarianDayOfMonth = currentDay + 10;
                } else {
                    bulgarianDayOfMonth = currentDay - 21;
                }
                if (!findIsLeapYear(Year.now().getValue())) {
                    bulgarianDayOfMonth -= 1;
                }
                break;
            case 11:
                if (currentDay >= 1 && currentDay <= 20) {
                    bulgarianDayOfMonth = currentDay + 10;
                } else {
                    bulgarianDayOfMonth = currentDay - 20;
                }
                if (!findIsLeapYear(Year.now().getValue())) {
                    bulgarianDayOfMonth -= 1;
                }
                break;
            case 12:
                if (currentDay >= 1 && currentDay <= 20) {
                    bulgarianDayOfMonth = currentDay + 10;
                } else if (currentDay == 21) {
                    bulgarianDayOfMonth = 0;
                } else {
                    bulgarianDayOfMonth = currentDay - 21;
                }
                if (!findIsLeapYear(Year.now().getValue())) {
                    bulgarianDayOfMonth -= 1;
                }
                break;
        }
        return bulgarianDayOfMonth;
    }

    private static boolean findIsLeapYear(int currentYear) {
        return (currentYear % 4 == 0 && currentYear % 100 != 0) || (currentYear % 400 == 0);
    }

    private static String findYearType(int bulgarianDateYear) {
        int bulgarianDateYearTypeIndex = bulgarianDateYear % 12;
        String bulgarianDateYearType = "";
        switch (bulgarianDateYearTypeIndex) {
            case 0:
                bulgarianDateYearType = "Верени";
                break;
            case 1:
                bulgarianDateYearType = "Дилом";
                break;
            case 2:
                bulgarianDateYearType = "Имен";
                break;
            case 3:
                bulgarianDateYearType = "Теку";
                break;
            case 4:
                bulgarianDateYearType = "Бечин";
                break;
            case 5:
                bulgarianDateYearType = "Тох";
                break;
            case 6:
                bulgarianDateYearType = "Етх";
                break;
            case 7:
                bulgarianDateYearType = "Докс";
                break;
            case 8:
                bulgarianDateYearType = "Сомор";
                break;
            case 9:
                bulgarianDateYearType = "Шегор";
                break;
            case 10:
                bulgarianDateYearType = "Барс";
                break;
            case 11:
                bulgarianDateYearType = "Дван";
                break;

        }
        return bulgarianDateYearType;
    }

    public static String returnBulgarianDate() {
        BulgarianDate testDate1 = new BulgarianDate();
        return testDate1.bulgarianDateDay + " "
                + testDate1.bulgarianDateMonth + ", "
                + testDate1.bulgarianDateYear + " "
                + testDate1.bulgarianDateTypeOfYear;
    }


}
