/**
 * Генерация правильных скобочных последовательностей
 */
public class B_Brackets {
    private int N;

    B_Brackets(int N) {
        this.N = N;
    }

    public static void main(String[] args) {
        for (int N = 3; N <= 6; N++) {
            System.out.println("N = " + N);
            new B_Brackets(N).generate("", 0, 0);
        }
    }

    /**
     * Генерация правильных скобочных
     * последовательностей
     *
     * @param s     Результирующая строка
     * @param open  Кол-во уже поставленных открывающих
     * @param close Кол-во поставленных закрывающих
     */
    void generate(String s, int open, int close) {
        if (N < 0)
            throw new IllegalArgumentException("N >= 0");
        if (open < 0)
            throw new IllegalArgumentException("open >= 0");
        if (close < 0)
            throw new IllegalArgumentException("close >= 0");
        if (open > N)
            throw new IllegalArgumentException("open > N");
        if (close > N)
            throw new IllegalArgumentException("close > N");
        // Вывод ответа
        // Только в том случае, если количество
        // открывающих N и количество закрывающих N
        if (open == N && close == N) {
            System.out.println(s);
            return;
        }
        // Когда мы можем добавить в конец строки
        // открывающую скобку?
        // Ограничения:
        //   Открывающих скобок должно быть не больше N
        // "()()((" + "("
        if (open < N)
            generate(s + "(", open + 1, close);
        // Когда мы можем добавить в конец строки
        // закрывающую скобку?
        // Когда открывающих больше закрывающих
        if (open > close)
            generate(s + ")", open, close + 1);
    }
}
