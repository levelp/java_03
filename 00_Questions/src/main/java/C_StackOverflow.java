/**
 * Демонстрация переполнения стека
 * java.lang.StackOverflowError
 */
public class C_StackOverflow {
    public static void main(String[] args) {
        recursion(1);
    }

    private static void recursion(int call) {
        System.out.println("call = " + call);
        recursion(call + 1);
    }
}
