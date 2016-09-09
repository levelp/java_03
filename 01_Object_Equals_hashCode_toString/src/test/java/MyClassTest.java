import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.*;

/**
 * Тестирование
 */
public class MyClassTest {
    @Test
    public void test1() {
        MyClass myClass1 = new MyClass("name");
        MyClass myClass2 = new MyClass("name");
        System.out.println("myClass1 = " + myClass1);
        System.out.println("myClass2 = " + myClass2);
        assertEquals(myClass1, myClass2);
        assertNotEquals(myClass1.hashCode(),
                myClass2.hashCode());

        HashSet<MyClass> set = new HashSet<>();
        set.add(new MyClass("name"));
        assertFalse(set.contains(new MyClass("name")));

        HashSet<String> strings = new HashSet<>();
        String s1 = "name";
        String s2 = "name";
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        strings.add(s1);
        assertTrue(strings.contains(s2));
    }

    @Test
    public void testMyClass2() {
        MyClass2 myClass1 = new MyClass2("name");
        MyClass2 myClass2 = new MyClass2("name");
        System.out.println("myClass1 = " + myClass1);
        System.out.println("myClass2 = " + myClass2);
        assertEquals(myClass1, myClass2);
        assertEquals(myClass1.hashCode(),
                myClass2.hashCode());
        if (myClass1.equals(myClass2))
            assertEquals(myClass1.hashCode(),
                    myClass2.hashCode());
    }
}
