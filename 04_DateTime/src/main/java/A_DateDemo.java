import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//
// Все возможности форматирования даты:
// https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html
public class A_DateDemo {

    public static void main(String[] args) throws ParseException {
        //
        // Форматирование даты:
        // * yyyy - год 4 цифры
        // * MM - месяц 2 цифры
        // * dd - день в месяце 2 цифры
        // * HH - час 2 цифры
        // * mm - минута 2 цифры
        // * ss - секунда 2 цифры
        //-->
        Date date = new Date(); // Текущая дата и время
        System.out.println("date = " + date);
        SimpleDateFormat dateFormat =
                new SimpleDateFormat(
                        "'Дата и время:' dd.MM.yyyy HH:mm:ss");

        // Форматирование даты
        System.out.println(dateFormat.format(date));

        // Разбор даты
        SimpleDateFormat russianDate =
                new SimpleDateFormat("dd.MM.yyyy");
        Date date2 = russianDate.parse("11.10.2014");
        System.out.println(date2);

        // MM/dd/yyyy - американский
        // Китайский формат даты
        SimpleDateFormat chineseDate =
                new SimpleDateFormat("yyyy-MM-dd");
        Date date3 = chineseDate.parse("2015-09-15");
        System.out.println(
                russianDate.format(date3));

        System.out.println(dateFormat.format(date2));

        // Изменяю время, ставлю 10 часов
        date.setHours(10); // Deprecated
        date.setMinutes(12);
        date.setSeconds(11);
        //date.setDate();
        //<--
    }
}
