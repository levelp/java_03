import org.joda.time.LocalDate;
import org.junit.Test;

import java.text.SimpleDateFormat;

import static org.junit.Assert.assertEquals;

/**
 * joda.org date/time
 */
public class JodaTimeTest {

    /**
     * Формат даты в России
     */
    private static SimpleDateFormat russianDate =
            new SimpleDateFormat("dd.MM.yyyy");

    @Test
    public void testTime() {
        LocalDate d = new LocalDate(2015, 5, 30);
        assertEquals("Год", 2015, d.year().get());
        assertEquals("Месяц", 5, d.monthOfYear().get());
        assertEquals("День", 30, d.dayOfMonth().get());
        assertEquals("Год", 2015, d.getYear());
        assertEquals("Месяц", 5, d.getMonthOfYear());
        assertEquals("День", 30, d.getDayOfMonth());
        assertEquals("День недели", 6, d.getDayOfWeek());
        assertEquals("День в году", 150, d.getDayOfYear());
        assertEquals("30.05.2015", russianDate.format(d.toDate()));
    }
}
