import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//
// Все возможности форматирования даты:
// https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html
public class A_DateTest extends Assert {

    @Test
    public void testDate() throws ParseException {
        // Форматирование даты:
        // * yyyy - год 4 цифры
        // * MM - месяц 2 цифры
        // * dd - день в месяце 2 цифры
        // * HH - час 2 цифры
        // * mm - минута 2 цифры
        // * ss - секунда 2 цифры
        //-->
        Date date = new Date();
        System.out.println("date = " + date);
        SimpleDateFormat dateFormat =
                new SimpleDateFormat("'Дата и время:' dd.MM.yyyy HH:mm:ss");

        System.out.println(dateFormat.format(date));

        SimpleDateFormat russianDate =
                new SimpleDateFormat("dd.MM.yyyy");
        Date date1 = russianDate.parse("12.09.2015");
        Date date2 = russianDate.parse("11.10.2014");
        // Сравнение дат
        assertFalse(date2.after(date1));
        assertTrue(date2.before(date1));
        assertTrue(date1.after(date2));
        assertFalse(date1.before(date2));

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date1);
        assertEquals(2015, calendar.get(Calendar.YEAR));
        assertEquals(8, calendar.get(Calendar.MONTH));
        assertEquals(Calendar.SEPTEMBER, calendar.get(Calendar.MONTH));
        assertEquals(12, calendar.get(Calendar.DATE));
        assertEquals(12, calendar.get(Calendar.DAY_OF_MONTH));
        assertEquals(7, calendar.get(Calendar.DAY_OF_WEEK));
        assertEquals(255, calendar.get(Calendar.DAY_OF_YEAR));
        assertEquals(0, calendar.get(Calendar.HOUR));
        assertEquals(0, calendar.get(Calendar.MINUTE));
        assertEquals(0, calendar.get(Calendar.SECOND));

        System.out.println(date2);

        System.out.println(dateFormat.format(date2));

        // Изменяю время, ставлю 10 часов
        date.setHours(10); // Depreacted
        //<--
    }
}
