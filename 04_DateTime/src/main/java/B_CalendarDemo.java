import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static org.junit.Assert.assertEquals;

/**
 * Календарь
 */
public class B_CalendarDemo {
    private static final Locale LOCALE_RU = new Locale("RU");

    String months[] = {"Январь", "Февраль",
            "Март", "Апрель", "Май"
    };

    public static void main(String[] args) throws ParseException {
        //-->
        Calendar now = Calendar.getInstance();
        System.out.println("День месяца: " +
                now.get(Calendar.DAY_OF_MONTH));
        // Месяц нумеруется с нуля
        // 0 - январь
        // 11 - декабрь
        System.out.println("Месяц: " +
                (now.get(Calendar.MONTH) + 1));
        System.out.println("Год: " +
                now.get(Calendar.YEAR));

        System.out.println("Час: " +
                now.get(Calendar.HOUR));
        System.out.println("Минута: " +
                now.get(Calendar.MINUTE));
        System.out.println("Секунда: " +
                now.get(Calendar.SECOND));

        SimpleDateFormat dateFormat =
                new SimpleDateFormat("'Дата и время:' dd.MM.yyyy HH:mm:ss");
        Date date = now.getTime();
        System.out.println(dateFormat.format(date));

        SimpleDateFormat dateFormat2 =
                new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

        Calendar cal = Calendar.getInstance();
        Date parsedDate = dateFormat2.parse("03.03.2015 22:34:11");
        cal.setTime(parsedDate);
        assertEquals(2015, cal.get(Calendar.YEAR));
        // Час HOUR_OF_DAY: 00..23
        // HOUR - 00..11
        assertEquals(22, cal.get(Calendar.HOUR_OF_DAY));
        assertEquals(34, cal.get(Calendar.MINUTE));
        assertEquals(11, cal.get(Calendar.SECOND));

        SimpleDateFormat rusMonth =
                new SimpleDateFormat("MMMMM", LOCALE_RU);

        System.out.println(rusMonth.format(date));

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(rusMonth.parse("Сентябрь"));
        System.out.println(
                (calendar.get(Calendar.MONTH) + 1)
        );

        // Дата через 2 месяца
        Calendar afterTwoMonths = (Calendar) now.clone();
        afterTwoMonths.add(Calendar.MONTH, 2);

        SimpleDateFormat russianDate =
                new SimpleDateFormat("dd.MM.yyyy");
        System.out.println(russianDate.format(afterTwoMonths.getTime()));

        Calendar date2 = (Calendar) now.clone();
        date2.add(Calendar.HOUR, -30);
        System.out.println(dateFormat.format(date2.getTime()));
        //<--
    }
}
