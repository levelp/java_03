package lambda;

import static java.lang.System.out;

/**
 * Лямбда-выражения
 * ----------------
 */
public class LambdaDemo {

    public static void main(String[] args) {
        int[] ints = {1, 2, 4};
        /*
        new Operation() {
            @Override
            public int apply(int x, int y) {
                return x + y;
            }
        };
         */
        Operation multiply = new Operation() {
            @Override
            public int apply(int a, int b) {
                return a * b;
            }
        };
        out.println("Sum: " + map(ints, multiply));

        Operation op = (x, y) -> x + y;
        out.println("Sum: " + map(ints, op));
        out.println("Mul: " + map(ints, (x, y) -> x * y));
        out.println("Max: " + map(ints, (x, y) -> (x > y) ? x : y));
        out.println("Min: " + map(ints, (x, y) -> (x < y) ? x : y));
        out.println("Max (Math::max): " + map(ints, Math::max));
        out.println("Mul2: " + map(ints, LambdaDemo::mul));
    }

    private static int mul(int a, int b) {
        return a * b;
    }

    private static int map(int[] arr, Operation op) {
        if (arr.length < 1)
            throw new IllegalArgumentException("Массив должен содержать хотя бы один элемент");
        int res = arr[0];
        for (int i = 1; i < arr.length; i++)
            res = op.apply(res, arr[i]);
        return res;
    }
}
