import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Anastasiya Solodkaya.
 */
public class Wildcards {
    public static void main(String[] args) {
        // ? - любой тип
        List<?> objects = new ArrayList<Apple>();
        // не скомпилируется
//        objects.add(new Pear());
//        objects.add(new Apple());

        List<String> strings = new ArrayList<>();
        // не скомпилируется
//        print(objects);


        // ? extends ... - upper-bounded
        List<? extends Number> numbers = new ArrayList<Integer>();
        List<? extends Number> numbers2 = new ArrayList<Number>();

        // ? super ... - lower-bounded
        List<? super Exception> exceptions = new ArrayList<Throwable>();
        List<? super Exception> exceptions2 = new ArrayList<Exception>();

        // lower-bound usage
        addString(new ArrayList<String>(), "a");
        addString(new ArrayList<Object>(), "a");

        // trick
        exceptions.add(new IOException());
        exceptions.add(new Exception());
        // не скомпилируется, т.к. компилятор не уверен в том, что коллекция принимает Object: например
        // она может быть Throwable
//        exceptions.add(new Object());


    }

    public static void print(List<?> list) {
        for (Object x : list) System.out.println(x);
    }

    public static void sum(List<? extends Number> list) {
//        ...
    }


    // не получится с List<String>
//    public static void addString(List<Object> input, String value){
//        input.add(value);
//    }
    // не можем использовать - не добавить элемент
//    public static void addString(List<?> input, String value){
//        input.add(value);
//    }

    // не можем использовать - не добавить элемент
//    public static void addString(List<? extends Object> input, String value){
//        input.add(value);
//    }


    // не получится с List<String>
    public static void addString(List<? super String> input, String value) {
        input.add(value);
    }

}
