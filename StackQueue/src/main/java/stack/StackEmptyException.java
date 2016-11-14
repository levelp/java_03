package stack;

/**
 * Исключение когда стек пуст
 */
public class StackEmptyException extends RuntimeException {
    StackEmptyException() {
        super("Стек пуст");
    }
}
