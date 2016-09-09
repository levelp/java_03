<!-- doc.py -->
Установка и настройка Apache Tomcat: http://tomcat.apache.org
-------------------------------------------------------------
* http://tomcat.apache.org/download-80.cgi http://apache.cu.be/tomcat/tomcat-8/v8.5.5/bin/apache-tomcat-8.5.5.zip - скачивание Apache Tomcat
* Распаковать в папку на диске, например в D:\tomcat
* Настройка и запуск: https://github.com/levelp/tomcat




Object, equals, hashCode, toString
----------------------------------


Использование ссылки this
-------------------------
``` java
        // Создаём журнал
        Journal journal = new Journal();

        // И двух подписчиков
        User A = new User("Петя");
        User B = new User("Вася");
        A.subscribe(journal);
        B.subscribe(journal);

        // Два выпуска журнала
        journal.release("Сентябрь 2014");
        journal.release("Октябрь 2014");
```

``` java
        // Когда журнал выходит
        public void release(String name) {
            for (User user : users) {
                // Он отправляется всем подписчикам
                user.send(name);
            }
        }
```

[01_Object_Equals_hashCode_toString/src/main/java/ThisLink.java](01_Object_Equals_hashCode_toString/src/main/java/ThisLink.java)

Строки в Java: управление строками в java, функции для работы со строками
-------------------------------------------------------------------------

List
[02_Strings/src/test/java/StringsTest.java](02_Strings/src/test/java/StringsTest.java)

List, Set, Map, TreeMap, Iterator, ListIterator, Collections. empty
-------------------------------------------------------------------

https://habrahabr.ru/post/128269/
Структуры данных в картинках. ArrayList


``` java

/**
 * Бинарное дерево поиска
 * Левый наследник всегда меньше правого.
 * Для балансировки: CartesianTree? Декартово дерево поиска?
 */
class BinaryTree<T extends Comparable> implements SearchTree<T> {
    /**
     * Корневой элемент дерева
     */
    TreeNode root = null;

    /**
     * Добавление нового значения в дерево поиска
     *
     * @param value добавляемое значение
     */
    @Override
    public void add(T value) {
        TreeNode newNode = new TreeNode(value);

        if (root == null) {
            root = newNode;
            return;
        }
        TreeNode cur = root;
        // Бесконечный цикл, т.к. мы выходим только когда нашли узел
        // к которому можем "подвесить" новый узел, и тогда мы выходим
        // по return
        while (true) {
            if (value.compareTo(cur.value) > 0) {
                if (cur.right == null) {
                    // Мы нашли нужный узел, подвешиваем
                    cur.right = newNode;
                    return;
                }
                // Спускаемся "направо"
                cur = cur.right;
            } else {
                if (cur.left == null) {
                    // Мы нашли нужный узел
                    cur.left = newNode;
                    return;
                }
                // Спускаемся "налево"
                cur = cur.left;
            }
        }
    }

    /**
     * Поиск значения в дереве поиска
     *
     * @param value Значение
     * @return найдено ли значение?
     */
    @Override
    public boolean find(T value) {
        // Спускаемся вниз по дереву поиска
        TreeNode cur = root;
        while (cur != null) {
            // Нашли узел с нужным значением
            if (cur.value.equals(value))
                return true;
            // Выбираем куда идти дальше
            cur = (value.compareTo(cur.value) > 0) ? cur.right : cur.left;
        }
        return false;

    }

    @Override
    public int deep() {
        return (root == null) ? 0 : root.deep();
    }

    /**
     * Узел дерева
     */
    public class TreeNode {
        T value;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(T value) {
            this.value = value;
        }

        /**
         * @return глубина дерева
         */
        int deep() {
            int res = 1;
            if (left != null)
                res = max(res, left.deep() + 1);
            if (right != null)
                res = max(res, right.deep() + 1);
            return res;
        }
    }
}
```

[03_Collections/src/main/java/BinaryTree.java](03_Collections/src/main/java/BinaryTree.java)

List
[03_Collections/src/test/java/A_ListTest.java](03_Collections/src/test/java/A_ListTest.java)

``` java
        // Интерфейс =  Класс с реализацией этого интерфейса
        BinaryTreeNode<Integer> tree = new BinaryTreeNode<>();
        assertFalse(tree.find(3));
        tree.add(3);
        assertTrue(tree.find(3));
        assertFalse(tree.find(2));

        // Добавить новое значение
        tree.add(2);
        assertTrue(tree.find(2));
        assertTrue(tree.find(3));

        // Добавляем узел с большим значением
        tree.add(334);
        assertTrue(tree.find(2));
        assertTrue(tree.find(3));
        assertTrue(tree.find(334));
        assertFalse(tree.find(7789));
```

[03_Collections/src/test/java/BinaryTreeTest.java](03_Collections/src/test/java/BinaryTreeTest.java)

``` java
        Date date = new Date(); // Текущая дата и время
        System.out.println("date = " + date);
        SimpleDateFormat dateFormat =
                new SimpleDateFormat("'Дата и время:' dd.MM.yyyy HH:mm:ss");

        // Форматирование даты
        System.out.println(dateFormat.format(date));

        // Разбор даты
        SimpleDateFormat russianDate =
                new SimpleDateFormat("dd.MM.yyyy");
        Date date2 = russianDate.parse("11.10.2014");
        System.out.println(date2);

        SimpleDateFormat chineseDate =
                new SimpleDateFormat("yyyy-MM-dd");
        Date date3 = chineseDate.parse("2015-09-15");
        System.out.println(
                russianDate.format(date3));

        System.out.println(dateFormat.format(date2));

        // Изменяю время, ставлю 10 часов
        date.setHours(10); // Deprecated
        //date.setDate();
```

[04_DateTime/src/main/java/A_DateDemo.java](04_DateTime/src/main/java/A_DateDemo.java)

``` java
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
```

[04_DateTime/src/main/java/B_CalendarDemo.java](04_DateTime/src/main/java/B_CalendarDemo.java)

``` java
        LocalDate nowDate = new LocalDate();
        LocalDateTime now = new LocalDateTime();
        System.out.println(showDateTime(now));
        System.out.println(now.dayOfMonth().getAsText());
        System.out.println("День недели: " + now.dayOfWeek().getAsShortText());
        System.out.println("Через 10 дней: " + showDateTime(now.plusDays(10)));
        System.out.println(now.minusMonths(4).plusDays(3));

        System.out.println("Через 3 месяца и 10 дней и 2 часа: " +
                showDateTime(now.plusMonths(3).plusDays(10).plusHours(2)));

        System.out.println("Верхний предел: " + showDateTime(now.plusYears(100000)));
        System.out.println("Нижний предел: " + showDateTime(now.minusYears(100000)));

        System.out.println("US: " + dateFormat2.format(now.minusYears(100000).toDate()));

        // Печать даты
        SimpleDateFormat russianDate =
                new SimpleDateFormat("dd.MM.yyyy");
        System.out.println(russianDate.format(now.toDate()));

        LocalDate date = new LocalDate(2013, 5, 3);
        System.out.println(russianDate.format(date.toDate()));
```

[04_DateTime/src/main/java/C_JodaTimeDemo.java](04_DateTime/src/main/java/C_JodaTimeDemo.java)

``` java
        Date date = new Date();
        System.out.println("date = " + date);
        SimpleDateFormat dateFormat =
                new SimpleDateFormat("'Дата и время:' dd.MM.yyyy HH:mm:ss");

        System.out.println(dateFormat.format(date));

        SimpleDateFormat russianDate =
                new SimpleDateFormat("dd.MM.yyyy");
        Date date1 = russianDate.parse("12.09.2015");
        Date date2 = russianDate.parse("11.10.2014");
        assertTrue(date2.after(date1));
        assertTrue(date2.before(date1));
        assertTrue(date1.after(date1));
        assertTrue(date1.before(date1));

        System.out.println(date2);

        System.out.println(dateFormat.format(date2));

        // Изменяю время, ставлю 10 часов
        date.setHours(10); // Depreacted
```

[04_DateTime/src/test/java/A_DateTest.java](04_DateTime/src/test/java/A_DateTest.java)

Базовый класс для всех исключений:
Throwable

Checked - наследники класса Exception
Unchecked:
  - RuntimeException -
  - Error - критические ошибки, которые, как правило, нет смысла ловить внутри вашей
  прикладной программы



﻿Демонстрационные проекты
------------------------
https://github.com/PetrKudr/webissues.git



Домашнее задание
----------------
1. Посмотреть (запустить, разобрать, выполнить в режиме отладки) примеры к уроку:
 * https://github.com/levelp/HelloJSP.git
 * https://github.com/levelp/WebInterface.git
2. Реализовать решение своей задачи с таким же Web-интерфейсом:
 * Генерация скобочных последовательностей ...или...
 * Разложить число на слагаемые
 * ....какая-то другая задача....
 * Начальная или самая важная страница вашего приложения (проекта)

Полезные статьи для чтения
--------------------------
* https://habrahabr.ru/post/248865/ - опыт прохождения собеседования на позицию java developer
* https://habrahabr.ru/post/309222/ - maven



