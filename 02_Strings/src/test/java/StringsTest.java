import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

import static org.junit.Assert.*;

// Работа со строками
public class StringsTest extends Assert {
    @Test
    public void testStrings() {
        // Создаем строчку
        String s = "Hello, world!";

        assertEquals('H', s.charAt(0));
        assertEquals('e', s.charAt(1));
        assertEquals('l', s.charAt(2));
        assertEquals('l', s.charAt(3));
        assertEquals('o', s.charAt(4));

        try {
            char c = s.charAt(100);
            fail("Должно быть " + StringIndexOutOfBoundsException.class.getName());
        } catch (StringIndexOutOfBoundsException e) {
            assertEquals("String index out of range: 100", e.getMessage());
        }
    }
}
