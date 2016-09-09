import java.util.ArrayList;
import java.util.List;

/**
 * @author Anastasiya Solodkaya.
 */
public class Basket<E extends Fruit> {

    private List<E> items;

    public Basket() {
        this.items = new ArrayList<>();
    }

    public void add(E item) {
        if (item == null) {
            throw new NullPointerException();
        }
        items.add(item);
    }

    public E get(int index) {
        return items.get(index);
    }

    // E - параметр, относящийся к экземпляру
//    public static E getStatic(int index){
//        return items.get(index);
//    }

    public static void main(String[] args) {
        Basket<Pear> basket = new Basket<>();
        basket.add(new Pear());
//        не скомпилируется
//        basket.add(new Apple());


        Basket<Fruit> basket2 = new Basket<>();
        basket2.add(new Pear());
        basket2.add(new Apple());

//        Basket b = new Basket();
//        b.add(new Object());
    }
}
