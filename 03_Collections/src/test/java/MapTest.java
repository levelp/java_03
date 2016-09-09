import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Map
 */
public class MapTest extends Assert {

    /**
     * Только HashMap
     * TreeMap - Caused by: java.lang.ClassCastException: java.lang.Class cannot be cast to java.lang.Comparable
     */
    static Map<Class, Class> types = new HashMap<>();

    static {
        types.put(Byte.TYPE, Byte.class);
        types.put(Short.TYPE, Short.class);
        types.put(Integer.TYPE, Integer.class);
        types.put(Long.TYPE, Long.class);
        types.put(Float.TYPE, Float.class);
        types.put(Double.TYPE, Double.class);
        types.put(Character.TYPE, Character.class);
        types.put(Boolean.TYPE, Boolean.class);
    }

    @Test
    public void testMapOperations() {
        Map<String, String> map = new HashMap<String, String>();

        assertTrue("Список пуст", map.isEmpty());

        // put( КЛЮЧ, ЗНАЧЕНИЕ )
        map.put("Hi", "Привет");
        assertEquals(1, map.size());

        map.put("Size", "Размер");

        // значение = get( КЛЮЧ )
        assertEquals("Привет", map.get("Hi"));
    }
}
