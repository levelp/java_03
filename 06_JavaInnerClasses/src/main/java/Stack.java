import java.util.EmptyStackException;

/**
 * Стек
 */
public class Stack<T> {
    /**
     * Корень стека
     */
    private StackElement<T> root = null;

    public boolean isEmpty() {
        return root == null;
    }

    public void push(T value) {
        StackElement<T> element = new StackElement<>(value);
        element.next = root;
        // Помещаем новый элемент на вершину
        root = element;
    }

    public T pop() {
        if (root == null)
            throw new EmptyStackException();
        // Запоминаем значение
        T value = root.value;
        // Переводим вершину стека на следующий элемент
        root = root.next;
        // Возвращаем значение
        return value;
    }

    /**
     * Один элемент стека
     *
     * @param <T>
     */
    private static class StackElement<T> {
        T value;
        StackElement<T> next = null;

        StackElement(T value) {
            this.value = value;
        }
    }
}
