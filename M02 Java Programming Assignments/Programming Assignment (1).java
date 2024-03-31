+------------------------+
|        MyDate          |
+------------------------+
| -year: int             |
| -month: int            |
| -day: int              |
+------------------------+
| +MyDate()              |
| +MyDate(elapsedTime: long) |
| +MyDate(year: int, month: int, day: int) |
| +getYear(): int        |
| +getMonth(): int       |
| +getDay(): int         |
| +setDate(elapsedTime: long): void |
+------------------------+


import java.util.GregorianCalendar;

public class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate() {
        this(System.currentTimeMillis());
    }

    public MyDate(long elapsedTime) {
        setDate(elapsedTime);
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public void setDate(long elapsedTime) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTimeInMillis(elapsedTime);
        year = calendar.get(GregorianCalendar.YEAR);
        month = calendar.get(GregorianCalendar.MONTH);
        day = calendar.get(GregorianCalendar.DAY_OF_MONTH);
    }

    public static void main(String[] args) {
        MyDate date1 = new MyDate();
        MyDate date2 = new MyDate(34355555133101L);

        System.out.println("Date1: " + date1.getYear() + "/" + (date1.getMonth() + 1) + "/" + date1.getDay());
        System.out.println("Date2: " + date2.getYear() + "/" + (date2.getMonth() + 1) + "/" + date2.getDay());
    }
}
