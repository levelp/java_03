import org.junit.Assert;
import org.junit.Test;

/**
 * Тестирование стека
 */
public class StackTest extends Assert {

    @Test
    public void testIntegerStack() {
        Stack<Integer> stack = new Stack<>();
        assertTrue(stack.isEmpty());
        stack.push(10);
        assertFalse(stack.isEmpty());
        stack.push(20);
        assertEquals(20, stack.pop().intValue());
        assertEquals(10, stack.pop().intValue());
        assertTrue(stack.isEmpty());
    }
}
