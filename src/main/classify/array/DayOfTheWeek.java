package main.classify.array;

public class DayOfTheWeek {

    public String dayOfTheWeek(int day, int month, int year) {
        int[] m = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        //1971-1-1 is Friday
        String[] res = new String[]{"Friday", "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday"};
        int days = dayOfYearsFrom1971(year);
        if (isLeap(year)) {
            m[2] = 29;
        }
        for (int i = 0; i < month; i++) {
            days += m[i];
        }
        days += day;
        days--;
        return res[days%7];
    }


    private int dayOfYearsFrom1971(int year) {
        int count = 0;
        for (int i = 1971; i < year; i++) {
            if (isLeap(i)) {
                count += 366;
            } else {
                count += 365;
            }
        }
        return count;
    }


    private boolean isLeap(int year) {
        if (year % 4 != 0) {
            return false;
        } else if (year % 100 != 0) {
            return true;
        } else if (year % 400 != 0) {
            return false;
        } else {
            return true;
        }
    }

}
