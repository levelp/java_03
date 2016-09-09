import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Очередь
 */
public class QueueTest extends Assert {

    @Test
    public void testQueueBaseOperations() {
        Queue<String> strings = new LinkedList<String>();
        strings.add("Test");
        assertEquals("Test", strings.poll());
    }
}
