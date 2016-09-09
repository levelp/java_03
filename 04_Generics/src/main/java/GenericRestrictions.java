import java.util.ArrayList;
import java.util.List;

/**
 * @author Anastasiya Solodkaya.
 */
public class GenericRestrictions<T> {
    List<Fruit> field = new ArrayList<>();

    public static void main(String[] args) {
        // 1
        List<Apple> apples = new ArrayList<>();
        List<Object> list;

        // не скомпилируется
//         list = apples;
//         list.add(new Pear());

    }

    public void typeErasure() {
        // 2 во время исполнения просто new Object()
//       new T();
        // 3 во время исполнения просто new Object[]{}
//        new T[]{};
        // 4 во время исполнения просто List
        List<Integer> list = new ArrayList<>();
//        if(list instanceof List<String>){
//
//        }

//         5 нельзя использовать примитивные типы
//        List<int> list;
    }


    // 4
    // T - параметр, относящийся к экземпляру
//    public static T getStatic(int index){
//        return items.get(index);
//    }
    // 5
//    private static T field0;
}
