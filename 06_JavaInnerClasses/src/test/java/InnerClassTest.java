import org.junit.Assert;
import org.junit.Test;

/**
 * Тесты на демонстрацию работы с внутренними классами
 */
public class InnerClassTest {

    @Test
    public void testAnonymClasses() {
        int i = 1;

        // Анонимный класс
        //-->
        MyInterface myInterface = new MyInterface() {
            @Override
            public void myMethod() {
                Assert.assertEquals(1, i);
                // i++; // Невозможно сделать
                System.out.println("InnerClassTest.myMethod");
            }
        };

        myInterface.myMethod();
        //<--
    }

    /**
     * Внутренний интерфейс
     */
    interface MyInterface {
        void myMethod();
    }
}
