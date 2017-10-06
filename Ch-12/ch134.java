import java.util.Calendar;
public class ch134 {
	static pch134 calendar;
    public static void main(String[] args) {
        int year;
        if (args.length == 1) {
            year = Calendar.getInstance().get(Calendar.YEAR);
        } else {
            year = new Integer(args[1]);
        }
        int month = Integer.parseInt(args[0]) - 1;
        calendar = new pch134(year, month, 1);
        calendar.set(Calendar.DATE, 1);

        printMonth();
    }

    
    public static void printMonth() {
        printMonthTitle();
        printMonthBody();
    }


    public static void printMonthTitle() {
        System.out.println("         " + calendar.getMonthName()
                + " " + calendar.get(Calendar.YEAR));
        System.out.println(" Mon Tue Wed Thu Fri Sat Sun ");
    }


    public static void printMonthBody() {
        int startDay = calendar.get(Calendar.DAY_OF_WEEK)-2 ;

        int numberOfDaysInMonth = calendar.daysInMonth();


        int i = 0;
        for (i = 0; i < startDay; i++)
            System.out.print("    ");

        for (i = 1; i <= numberOfDaysInMonth; i++) {
            System.out.printf("%4d", i);

            if ((i + startDay) % 7 == 0)
                System.out.println();
        }

        System.out.println();
    }


}