import java.util.ArrayList;
import java.util.List;

/**
 * @author Anastasiya Solodkaya.
 */
public class ListGenerics {
    public static void main(String[] args) {
        listOfApples();
        listOfFruits();
    }


    private static void listOfFruits() {
        // то же самое, что и List<Fruit> l = new ArrayList<Fruit>();
        List<Fruit> l = new ArrayList<>();
        l.add(new Apple());
        l.add(new Apple());
        l.add(new Pear());
        l.add(new Apple());

        Fruit fruit1 = l.get(2);
        Fruit fruit2 = l.get(3);
    }


    private static void listOfApples() {
        List<Apple> l = new ArrayList<>();
        l.add(new Apple());
        l.add(new Apple());
        // не скомпилируется
//         l.add(new Pear());
        l.add(new Apple());

        Apple apple1 = l.get(1);
        Apple apple2 = l.get(2);
    }
}
