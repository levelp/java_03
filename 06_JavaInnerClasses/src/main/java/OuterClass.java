import javax.swing.*;
import java.awt.event.ActionListener;

// Вложенные классы в Java
// -----------------------

/**
 * Внешний класс
 */
public class OuterClass<T> {
    static int staticOuterField;
    StaticInnerClass staticInnerClass = new StaticInnerClass();
    StaticInnerClass<Integer> integerStaticInnerClass = new StaticInnerClass<>();
    private int outerField;

    public OuterClass() {
    }

    static void staticMethod() {
        System.out.println("OuterClass.staticMethod");
    }

    /**
     * 1. Локальные классы - объявляются внутри методов основного класса.
     * Могут быть использованы только внутри этого же метода.
     * Имеют доступ к:
     * - всем полям и методам внешнего класса.
     * - к локальным переменным и параметрам метода если они объявлены final.
     * Не могут содержать определение (но могут наследовать)
     * статических полей, методов и классов (кроме констант).
     */
    void methodWithLocalClass(final int parameter) {
        InnerClass innerInsideMehod; // Эта строка кода синтаксически корректна
        int notFinal = 0;
        final int value = 10;

        final int forInner = notFinal;

        class LocalInnerClass {
            // Константа в локальном классе
            public final static int CONST = 1000;

            // static int staticVar = 100; // Ошибка компиляции

            int localField = 2;

            int getOuterField() {
                outerField++;
                return OuterClass.this.outerField;
            }

            public void m() {
                int v = value + 2;
                // Не можем менять локальных переменных
                // value++;
                staticOuterField++;

                System.out.println("forInner = " + forInner);
            }

            // notFinal++; // Ошибка компиляции
            int getParameter() {
                return parameter;
                // Эта строка синтаксически корректна
            }
        }

        // Можно создавать сколько угодно экземпляров локального класса
        // но только внутри данного метода
        LocalInnerClass localInnerClass = new LocalInnerClass();
        localInnerClass.m();

        LocalInnerClass aClass = new LocalInnerClass();
        aClass.m();
    }

    /**
     * 2. Анонимные (безымянные) классы -
     * объявляются внутри методов основного (внешнего) класса.
     * Могут быть использованы только внутри этих методов.
     * В отличие от локальных классов, анонимные классы не имеют названия.
     * Главное требование к анонимному классу -
     * он должен наследовать существующий класс или
     * реализовывать существующий интерфейс.
     * Не могут содержать определение (но могут наследовать) статических полей, методов и классов (кроме констант).
     */
    void methodWithAnonymousLocalClass(final int interval) {
        // При определении анонимного класса применен полиморфизм - переменная listener
        // содержит экземпляр анонимного класса, реализующего существующий
        // интерфейс ActionListener
        final int localVar = 2;
        ActionListener listener = new ActionListener() {
            // Начало анонимного локального класса >>>
            int myField = 10;

            @Override
            public void actionPerformed(java.awt.event.ActionEvent actionEvent) {
                outerField++;
                System.out.println("localVar = " + localVar);
                System.out.println("Эта строка выводится на экран каждые " + interval + " секунд");
            }
            // << Окончание
        };
        Runnable runnable = new Runnable() {
            int i = 10;

            @Override
            public void run() {
                System.out.println("run");
            }
        };
        runnable.run();


        Timer t = new Timer(interval, listener); // Объект анонимного класса использован внутри метода
        t.start();
    }

    /**
     * 3. Статический внутренний класс (с ключевым словом static):
     * Можем обращаться:
     * - к статическим полям внешнего класса
     * - к статическим методам внешнего класса
     * Не имеет доступа к нестатическим членам внешнего класса.
     * Может содержать статические поля, методы и классы,
     * в отличие от других типов внутренних классов.
     */
    public static class StaticInnerClass<T> {
        static int count = 0; // Статическое поле внутри

        int id;

        public StaticInnerClass() {
            id = ++count;
        }

        // Не можем обращаться к обычным полям класса
        //int getOuterField() {
        //    return OuterClass.this.outerField; // Эта строка кода - ошибка компиляции
        // }

        int getStaticOuterField() {
            T value;
            staticMethod();
            return OuterClass.staticOuterField; // Строка кода синтаксически корректна
        }
    }

    // LocalInnerClass inner; // Ошибка компиляции: локальные классы тут не видны

    /**
     * 4. Внутренние классы - объявляются внутри основного класса (без слова static).
     * В отличие от статических внутренних классов,
     * имеют доступ к членам внешнего класса.
     * Не могут содержать (но могут наследовать) определение
     * статических полей, методов и классов (кроме констант).
     */
    class InnerClass {
        public static final int INT_CONSTANT = 3;
        // static void xx(){ // Ошибка
        // }

        int getOuterField() {
            int i = INT_CONSTANT;
            System.out.println("i = " + i);
            staticMethod();
            staticOuterField = 20;
            return OuterClass.this.outerField;
        }
    }
}