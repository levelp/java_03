``` java
/**
 * Бинарное дерево поиска
 * Левый наследник всегда меньше правого.
 * Для балансировки: CartesianTree? Декартово дерево поиска?
 */
public class BinaryTree<T extends Comparable> implements SearchTree<T> {
    /**
     * Корневой элемент дерева
     */
    public TreeNode root = null;

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
    class TreeNode {
        public T value;
        public TreeNode left = null;
        public TreeNode right = null;

        public TreeNode(T value) {
            this.value = value;
        }

        /**
         * @return глубина дерева
         */
        public int deep() {
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
Фиктивный узел (без значения)
Игнорируем такое же значение
Это фиктивный узел => мы не нашли значения
Нашли нужное значение
Тернарный оператор
(УСЛОВИЕ) ? ЗНАЧЕНИЕ_ЕСЛИ_TRUE : ЗНАЧЕНИЕ_ЕСЛИ_FALSE
Работает так же, как:
if (value == null)
result = 0;
else
result = 1;
TODO: join + split
здесь будут операции...
Интерфейс =  Класс с реализацией этого интерфейса
Добавить новое значение
Добавляем узел с большим значением
Генератор случайных чисел
Проверочный set
``` java
        // Интерфейс =  Класс с реализацией этого интерфейса
        BinaryTreeNode<Integer> tree = new BinaryTreeNode<Integer>();
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
Оптимизация: final List<T> l = new ArrayList<T>(array.length);
Интерфейс =  Класс с реализацией этого интерфейса
Очередь: Queue<Integer>
Метод add() добавить в конец списка
size() - количество элементов в списке
get(index) - получить элемент с заданным индексом
Добавить элемент в заданнную позицию (элементы с большими индексами сдвигаются вправо)
Теперь 3 элемента: {7, 11, 10}
Преобразование в массив
Добавляем сразу массив элементов
remove(Object o) - удаление элемента по значению
contains(Object o) - наличия элемента в списке
Проверка, содержит ли один список другой список
set(int index, E element)
Список с индекса по индекс [fromIndex, toIndex)
1, 1, 2..
Получаем итератор
Удаляем элемент
i.remove(); // java.lang.UnsupportedOperationException
Метод add() добавить в множество
size() - количество элементов в списке
get(index) - получить элемент с заданным индексом
Добавляем сразу массив элементов
remove(Object o) - удаление элемента по значению
contains(Object o) - наличия элемента в списке
Проверка, содержит ли один список другой список
Получаем итератор
Удаляем элемент
i.remove(); // java.lang.UnsupportedOperationException

Date, Calendar, DateFormat (Format). Joda-Time
----------------------------------------------



Все возможности форматирования даты:
https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html

Форматирование даты:
* yyyy - год 4 цифры
* MM - месяц 2 цифры
* dd - день в месяце 2 цифры
* HH - час 2 цифры
* mm - минута 2 цифры
* ss - секунда 2 цифры
``` java
        Date date = new Date();
        System.out.println("date = " + date);
        SimpleDateFormat dateFormat =
           new SimpleDateFormat("'Дата и время:' dd.MM.yyyy HH:mm:ss");

        System.out.println(dateFormat.format(date));

        SimpleDateFormat russianDate =
                new SimpleDateFormat("dd.MM.yyyy");
        Date date2 = russianDate.parse("11.10.2014");
        System.out.println(date2);

        System.out.println(dateFormat.format(date2));

        // Изменяю время, ставлю 10 часов
        date.setHours(10);
```
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
        System.out.println(dateFormat.format(now.getTime()));

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

        System.out.println(rusMonth.format(now.getTime()));

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

﻿JavaFX
======


