import java.util.ArrayList;
import java.util.List;

public class WildcardsExample {
    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<>();
        print2(apples);

        List<? extends Object> l = new ArrayList<Apple>();
        // l.add(new Apple());
        // Error:(10, 10) java: no suitable method found for add(Apple)
        // method java.util.Collection.add(capture#1 of ? extends java.lang.Object) is not applicable
        //         (argument mismatch; Apple cannot be converted to capture#1 of ? extends java.lang.Object)
        // method java.util.List.add(capture#1 of ? extends java.lang.Object) is not applicable
        //         (argument mismatch; Apple cannot be converted to capture#1 of ? extends java.lang.Object)
    }

    private static void print2(List<Apple> apples) {
        for (Apple apple : apples)
            System.out.println(apple);
    }

    // raw
    public static void print(List<? extends CharSequence> elements) {
        StringBuilder j = new StringBuilder();

        for (CharSequence element : elements) {
            j.append(element);
        }
        System.out.println(j);
    }

    public void addString(List<? super String> l) {
        l.add("ll");
    }
}
