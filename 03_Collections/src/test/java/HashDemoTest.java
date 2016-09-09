import org.junit.Assert;
import org.junit.Test;

public class HashDemoTest extends Assert {
    @Test
    public void test() {
        HashTable table = new HashTable(100);

        String[] tests = {"test", "Hello", "group", "test"};
        for (String test : tests) {
            System.out.println("hash(\"" + test + "\") = "
                    + table.hash(test));
        }

        table.add("test");

        assertEquals("test", table.get("test"));
        assertNull(table.get("test2"));
    }
}
