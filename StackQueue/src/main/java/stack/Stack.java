package stack;

public class Stack<T> {
    private final T[] data;
    private int top = 0;

    @SuppressWarnings("unchecked")
    public Stack(int size) {
        data = (T[]) new Object[size];
    }

    /**
     * Добавить значение на вершину стека
     *
     * @param value значение для добавления
     */
    public void push(T value) {
        if (top == data.length)
            throw new StackFullException();
        data[top++] = value;
    }

    //public void addString() {
    //    data[top++] = "Test";
    //}

    public T pop() {
        if (top == 0)
            throw new StackEmptyException();
        return (T) data[--top];
    }
}
