import java.util.ArrayList;
import java.util.List;

/**
 * @author Anastasiya Solodkaya.
 */
public class ListNoGenerics {
    public static void main(String[] args) {
        listNoGenerics();
    }

    private static void listNoGenerics() {
        List l = new ArrayList();
        l.add(new Apple()); // 0
        l.add(new Apple()); // 1
        l.add(new Pear()); // 2
        l.add(new Apple()); // 3

        Object object1 = l.get(1);
        Apple apple1 = (Apple) object1;

        Object object2 = l.get(2);
        Apple apple2 = (Apple) object2; // ClassCastException, 3й элемент - Pear

    }
}
