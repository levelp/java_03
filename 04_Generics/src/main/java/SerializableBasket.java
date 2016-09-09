import java.io.Serializable;

/**
 * @author Anastasiya Solodkaya.
 */
public class SerializableBasket<E extends Fruit & Serializable> extends Basket<E> {
    public static void main(String[] args) {
        // не скомпилируется: Pear не Serializable
//         SerializableBasket<Pear> basket0 = new SerializableBasket<>();

        // не скомпилируется: Fruit не Serializable
//         SerializableBasket<Fruit> basket0 = new SerializableBasket<>();

        SerializableBasket<Apple> basket = new SerializableBasket<>();
        basket.add(new Apple());


    }

}
