import static org.junit.Assert.assertEquals;

/**
 * Рекурсия
 * <p>
 * Факториал:  N!=1*2*3*...*N
 * <p>
 * Итеративно - с помощью цикла.
 * Рекурсивно:
 * функция вызывает сама себя
 */
public class A_Recursion {

    public static void main(String[] args) {
        for (int i = 6; i <= 10; i++) {
            System.out.println(i + "! = " +
                    fact(i));
            assertEquals(fact(i), factIt(i));
        }
    }

    /**
     * Рекурсивное вычисление факториала
     *
     * @param N аргумент (для какого числа
     *          считаем)
     * @return значение факториала
     */
    private static long fact(int N) {
        if (N <= 1)
            return 1;
        else {
            long result = fact(N - 1) * N;
            System.out.println("result = " + result);
            return result;
        }
    }

    /**
     * Итеративный
     *
     * @param N
     * @return
     */
    private static long factIt(int N) {
        long result = 1;
        for (int i = 2; i <= N; i++)
            result = result * N;
        return result;
    }
}
