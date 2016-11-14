import java.util.ArrayList;
import java.util.List;

/**
 * @author Anastasiya Solodkaya.
 */
public class GenericMethods<R> {

    public static <T> void genericStaticMethod(T element) {
    }

    public static void main(String[] args) {
        GenericMethods<String> m = new GenericMethods<>();

        // T -> Integer, E - Boolean, P - Number
        Integer i = m.genericMethod(new ArrayList<Number>(), false);
        // явное указание
        Integer result = m.<Number, Boolean, Integer>genericMethod(new ArrayList<>(), false);
    }

    public <T> R genericInstanceMethod(T element, R element2) {
        return null;
    }

    public <T, E, P extends T> P genericMethod(List<T> list, E element) {
        return null;
    }
}
