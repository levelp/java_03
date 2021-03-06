import org.junit.Assert;
import org.junit.Test;
import stack.Stack;
import stack.StackEmptyException;

public class StackTest extends Assert {
    @Test
    public void testStack() {
        Stack<Integer> stack = new Stack<>(10);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.pop().intValue());
        assertEquals(2, stack.pop().intValue());
        assertEquals(1, stack.pop().intValue());

        try {
            stack.pop();
            fail("StackEmptyException expected");
        } catch (StackEmptyException exception) {
            assertEquals("Стек пуст", exception.getMessage());
        }
    }
}
