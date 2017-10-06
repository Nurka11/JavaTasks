import java.util.GregorianCalendar;

public class pch134 extends GregorianCalendar {

    public pch134(int year, int month, int dayOfMonth) {
        super(year, month, dayOfMonth);

    }

    public String getMonthName() {
        return getMonthName(get(MONTH));
    }

    public static String getMonthName(int month) {
        String monthName = null;

        switch (month) {
            case 0: monthName = "January"; break;
            case 1: monthName = "February"; break;
            case 2: monthName = "March"; break;
            case 3: monthName = "April"; break;
            case 4: monthName = "May"; break;
            case 5: monthName = "June"; break;
            case 6: monthName = "July"; break;
            case 7: monthName = "August"; break;
            case 8: monthName = "September"; break;
            case 9: monthName = "October"; break;
            case 10: monthName = "November"; break;
            case 11: monthName = "December"; break;
            default:
        }

        return monthName;
    }

    public static String getDayOfWeekName(int day) {
        String dayOfWeekName = null;

        day = day % 7;

        switch (day) {
            case 0: dayOfWeekName = "Sunday"; break;
            case 1: dayOfWeekName = "Monday"; break;
            case 2: dayOfWeekName = "Tuesday"; break;
            case 3: dayOfWeekName = "Wednesday"; break;
            case 4: dayOfWeekName = "Thursday"; break;
            case 5: dayOfWeekName = "Friday"; break;
            case 6: dayOfWeekName = "Saturday"; break;
            default:
        }

        return dayOfWeekName;
    }


    public int daysInMonth() {
        switch (get(MONTH)) {
            case 0:
            case 2:
            case 4:
            case 6:
            case 7:
            case 9:
            case 11:
                return 31;
            case 1:
                if (isLeapYear(get(YEAR))) return 29;
                else return 28;
            case 3:
            case 5:
            case 8:
            case 10:
                return 30;
            default: return 0;
        }
    }
    public static int daysInMonth(int month, int year) {
        return new pch134(year, month, 1).daysInMonth();
    }


    public int getStartDay() {

        int month = get(MONTH) + 1;
        int day = 1;
        int year = get(YEAR);

        if (month == 1) {
            month = 13;
            year--;
        } else if (month == 2) {
            month = 14;
            year--;
        }

        int k = year % 100;
        int j = year / 100;
        return ((day + 26 * (month + 1) / 10 + k + k / 4 + j / 4 + 5 * j) - 1) % 7;
    }


}