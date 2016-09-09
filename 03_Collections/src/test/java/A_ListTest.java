/// List

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

import static org.junit.Assert.*;

/**
 * Список элементов
 */
public class A_ListTest {
    static <T> List<T> arrayToList(final T[] array) {
        final List<T> l = new ArrayList<T>();
        // Оптимизация: final List<T> l = new ArrayList<T>(array.length);
        Collections.addAll(l, array);
        return l;
    }

    /**
     * Старый список, в котором каждый
     * элемент может быть любого типа
     */
    @Test
    public void oldList() {
        List list = new ArrayList();
        list.add(2); // Integer
        list.add("Test");
        list.add(2.3); // Double
        list.add(new MyClass());
        for (Object obj : list)
            System.out.println(obj);

        assertEquals(4, list.size());
        for (int i = 0; i < list.size(); ++i)
            System.out.println("list[" + i + "] = " +
                    list.get(i));

        for (Object obj : list)
            if (obj instanceof Integer) // Фильтр по Integer
                System.out.println(obj);
    }

    /**
     * Список
     */
    @Test
    public void lists() throws Exception {
        // Интерфейс =  Класс с реализацией этого интерфейса
        // List<MyClass>  - элементы только MyClass и наследники
        List<Integer> integers = new ArrayList<Integer>();
        integers.add(100);

        // Стирание типов
        // Очищаем список
        integers.clear();

        //integers.add("Test");
        Class listClass = integers.getClass();
        // Получаем метод add, вызываем его с произвольными параметрами
        Method addMethod = listClass.getMethod("add", Object.class);
        addMethod.invoke(integers, "Test");
        assertEquals(1, integers.size());

        // Получаем список объектов, добавляем или заменяем элементы на элементы другого типа
        Field data = listClass.getDeclaredField("elementData");
        data.setAccessible(true); // Включаем доступ, поскольку поле private
        Object[] elementData = (Object[]) data.get(integers);
        assertEquals("Test", elementData[0].toString());

        integers.clear();

        assertTrue("Список пуст", integers.isEmpty());

        // Очередь: Queue<Integer>

        // Метод add() добавить в конец списка
        integers.add(7);
        integers.add(10);
        assertFalse("Теперь уже не пуст", integers.isEmpty());

        // size() - количество элементов в списке
        assertEquals("В списке 2 элемента", 2, integers.size());
        // get(index) - получить элемент с заданным индексом
        Integer integer = integers.get(0);
        assertEquals("0-ой элемент", 7, integer.intValue());
        assertEquals("1-ый элемент", 10, integers.get(1).intValue());

        // Добавить элемент в заданнную позицию (элементы с большими индексами сдвигаются вправо)
        integers.add(1, 11);

        // Теперь 3 элемента: {7, 11, 10}
        assertEquals(3, integers.size());
        assertEquals(7, integers.get(0).intValue());
        assertEquals(11, integers.get(1).intValue());
        assertEquals(10, integers.get(2).intValue());
        // Преобразование в массив
        Integer[] intArray = listToArray(integers);
        assertArrayEquals(new Integer[]{7, 11, 10}, intArray);

        // Добавляем сразу массив элементов
        integers.addAll(Arrays.asList(2, 5, 6));
        assertArrayEquals(new Integer[]{7, 11, 10, 2, 5, 6}, listToArray(integers));

        Integer[] newValues = {88, 99};
        integers.addAll(2, Arrays.asList(newValues));
        assertArrayEquals(new Integer[]{7, 11, 88, 99, 10, 2, 5, 6}, listToArray(integers));

        // remove(Object o) - удаление элемента по значению
        integers.remove(new Integer(99)); // Не так: ints.remove(99);
        assertArrayEquals(new Integer[]{7, 11, 88, 10, 2, 5, 6}, listToArray(integers));

        integers.remove(1); // Удалить элемент с индексом 1
        assertArrayEquals(new Integer[]{7, 88, 10, 2, 5, 6}, listToArray(integers));

        // contains(Object o) - наличия элемента в списке
        assertTrue(integers.contains(7));
        assertTrue(integers.contains(88));
        assertFalse(integers.contains(89));

        // Проверка, содержит ли один список другой список
        assertTrue("Содержатся все эти элементы",
                integers.containsAll(arrayToList(new Integer[]{7, 10, 2})));

        // set(int index, E element)
        assertArrayEquals(new Integer[]{7, 88, 10, 2, 5, 6}, listToArray(integers));
        integers.set(1, 100); // Меняем элемент
        assertArrayEquals(new Integer[]{7, 100, 10, 2, 5, 6}, listToArray(integers));

        // Список с индекса по индекс [fromIndex, toIndex)
        assertArrayEquals(new Integer[]{100, 10}, listToArray(integers.subList(1, 3)));
    }

    /**
     * Сравнение списков напрямую
     */
    @Test
    public void testCompareLists() {
        // Сравниваем 2 списка напрямую
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
        assertEquals(list1, list2);

        list1.add(10);
        assertNotEquals(list1, list2);

        list2.add(10);
        assertEquals(list1, list2);

        List list3 = new ArrayList();
        list3.add(10);
        assertEquals(list1, list3);
    }

    /**
     * Итератор
     */
    @Test
    public void iterators() {
        // 1, 1, 2..
        List<Integer> list = Arrays.asList(2, 3, 5, 8, 13);

        for (Integer i : list) {
            System.out.println("i = " + i);
        }

        // Получаем итератор
        Iterator<Integer> i = list.iterator();

        assertTrue("Следующий элемент есть", i.hasNext());
        assertEquals(2, i.next().intValue());

        assertTrue("Следующий элемент есть", i.hasNext());
        assertEquals(3, i.next().intValue());

        assertTrue("Следующий элемент есть", i.hasNext());
        assertEquals(5, i.next().intValue());

        assertTrue("Следующий элемент есть", i.hasNext());
        assertEquals(8, i.next().intValue());

        assertTrue("Следующий элемент есть", i.hasNext());
        assertEquals(13, i.next().intValue());

        // Удаляем элемент
        // i.remove(); // java.lang.UnsupportedOperationException

        assertFalse("Элементы кончились", i.hasNext());

        for (Integer value : list) {
            System.out.println(value);
        }

        Iterator<Integer> integerIterator = list.iterator();
        while (integerIterator.hasNext()) {
            System.out.println(integerIterator.next());
        }
    }

    private Integer[] listToArray(List<Integer> list) {
        return list.toArray(new Integer[list.size()]);
    }

    /**
     * В типизированном списке могут хранится не только
     * элементы с данным типом, но и наследники
     */
    @Test
    public void testMyClassInherit() {
        List<MyClass> myClassList = new ArrayList<MyClass>();
        myClassList.add(new MyClass());
        myClassList.add(new MyClass2());
    }
}
